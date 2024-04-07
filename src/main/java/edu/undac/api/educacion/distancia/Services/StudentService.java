package edu.undac.api.educacion.distancia.Services;

import edu.undac.api.educacion.distancia.Domain.Curse;
import edu.undac.api.educacion.distancia.Domain.Repositories.CurseRepository;
import edu.undac.api.educacion.distancia.Domain.Repositories.StudentSubjectRepository;
import edu.undac.api.educacion.distancia.Domain.Speciality;
import edu.undac.api.educacion.distancia.Domain.Student;
import edu.undac.api.educacion.distancia.Domain.Repositories.SpecialityRepository;
import edu.undac.api.educacion.distancia.Domain.Repositories.StudentRepository;
import edu.undac.api.educacion.distancia.Domain.StudentSubject;
import edu.undac.api.educacion.distancia.DTO.Responses.AlumnoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired private StudentRepository studentRepository;

    @Autowired private SpecialityRepository specialityRepository;

    @Autowired private StudentSubjectRepository studentSubjectRepository;

    @Autowired private CurseRepository curseRepository;

    @Autowired private RestTemplate restTemplate;

    private static String especialidad;

    private Optional<String> getCurricula(String alumno) {
        Optional<List<StudentSubject>> alumnoMatriculas = studentSubjectRepository.getByAlumno(alumno);
        String curricula = alumnoMatriculas.flatMap(matriculas -> matriculas.stream()
                .map(StudentSubject::getCodigoCurricula).findFirst())
                .orElse(null);
        Boolean result = alumnoMatriculas.filter(studentSubjects -> studentSubjects.stream()
                .allMatch(studentSubject -> studentSubject.getCodigoCurricula().equals(curricula)))
                .isPresent();
        return result ? Optional.of(curricula) : Optional.empty();
    }

    private int getCreditos(String especialidad, String curricula) {
        Optional<List<Curse>> curses = curseRepository.getByEspecialidadCurricula(especialidad, curricula);
        return curses.map(curses1 -> curses1.stream().mapToInt(Curse::getCreditos).sum()).orElse(0);
    }

    public Optional<AlumnoResponse> getAlumnoFromAPI(String codigo){
        StringBuilder direccion = new StringBuilder("http://distancia.undac.edu.pe:8080/" +
                "tasks/6996522b093b1c5560199ed48b553b9f/91f33e2776c526b9cca723a63476f028/" + codigo);
        URI url = URI.create(String.valueOf(direccion));
        AlumnoResponse alumnoResponse = restTemplate.getForObject(url, AlumnoResponse.class);
        return Optional.of(alumnoResponse).or(() -> Optional.empty());
    }

    public Optional<AlumnoResponse> getStudent (String code){
        Optional<Student> student = studentRepository.getAlumno(code);
        return student.map(student1 -> {
            AlumnoResponse alumno = new AlumnoResponse();
            Optional<String> curricula = getCurricula(student1.getCodigo());
            Optional<Speciality> speciality = specialityRepository.getById(student1.getIdEspecialidad());
            String apellidos = student1.getNombre().split(", ")[0];
            alumno.setNombres(student1.getNombre().split(", ")[1]);
            alumno.setApePaterno(apellidos.split(" ")[0]);
            alumno.setApeMaterno(apellidos.split(" ")[1]);
            if (curricula.isPresent()) {
                alumno.setCurricula(curricula.get() + student1.getIdEspecialidad());
                alumno.setCreditos(getCreditos(student1.getIdEspecialidad(), curricula.get()));
            } else {
                alumno.setCurricula("");
                alumno.setCreditos(0);
            }
            alumno.setEspecialidad(speciality.map(speciality1 -> speciality1.getNombre()).orElse(null));
            alumno.setIdEspecialidad(student1.getIdEspecialidad());
            alumno.setCorreo(student1.getCodigo() + "@gmail.com");
            alumno.setDni(student1.getCodigo());
            alumno.setFechaNacimiento("");
            alumno.setGenero("");
            alumno.setDomicilio("");
            alumno.setRol("EG");
            return alumno;
        });
    }

}
