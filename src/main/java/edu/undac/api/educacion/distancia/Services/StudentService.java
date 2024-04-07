package edu.undac.api.educacion.distancia.Services;

import edu.undac.api.educacion.distancia.Domain.Curse;
import edu.undac.api.educacion.distancia.Domain.Repositories.CurseRepository;
import edu.undac.api.educacion.distancia.Domain.Repositories.StudentSubjectRepository;
import edu.undac.api.educacion.distancia.Domain.Speciality;
import edu.undac.api.educacion.distancia.Domain.Student;
import edu.undac.api.educacion.distancia.Domain.Repositories.SpecialityRepository;
import edu.undac.api.educacion.distancia.Domain.Repositories.StudentRepository;
import edu.undac.api.educacion.distancia.Domain.StudentSubject;
import edu.undac.api.educacion.distancia.Models.AlumnoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {

    @Autowired private StudentRepository studentRepository;

    @Autowired private SpecialityRepository specialityRepository;

    @Autowired private StudentSubjectRepository studentSubjectRepository;

    @Autowired private CurseRepository curseRepository;

    @Autowired private RestTemplate restTemplate;

    private String getCurricula(String alumno) {
        Optional<List<StudentSubject>> alumnoMatriculas = studentSubjectRepository.getByAlumno(alumno);
        String curricula = alumnoMatriculas.flatMap(matriculas -> matriculas.stream()
                .map(StudentSubject::getCodigoCurricula).findFirst())
                .orElse(null);
        Boolean result = alumnoMatriculas.filter(studentSubjects -> studentSubjects.stream()
                .allMatch(studentSubject -> studentSubject.getCodigoCurricula().equals(curricula)))
                .isPresent();
        return result ? curricula : null;
    }

    private int getCreditos(String especialidad, String curricula) {
        Optional<List<Curse>> curses = curseRepository.getByEspecialidadCurricula(especialidad, curricula);
        return curses.map(curses1 -> curses1.stream().mapToInt(Curse::getCreditos).sum()).orElse(0);
    }

    public AlumnoResponse getAlumnoFromAPI(String codigo){
        StringBuilder direccion = new StringBuilder("http://distancia.undac.edu.pe:8080/" +
                "tasks/6996522b093b1c5560199ed48b553b9f/91f33e2776c526b9cca723a63476f028/" + codigo);
        URI url = URI.create(String.valueOf(direccion));
        AlumnoResponse alumnoResponse = restTemplate.getForObject(url, AlumnoResponse.class);
        return alumnoResponse;
    }

    public AlumnoResponse getStudent (String code){
            AlumnoResponse alumno = new AlumnoResponse();
            Student student = studentRepository.getAlumno(code);
            String curricula = getCurricula(student.getCodigo());
            Optional<Speciality> speciality = specialityRepository.getById(student.getIdEspecialidad());
            String apellidos = student.getNombre().split(", ")[0];
            alumno.setNombres(student.getNombre().split(", ")[1]);
            alumno.setApePaterno(apellidos.split(" ")[0]);
            alumno.setApeMaterno(apellidos.split(" ")[1]);
            if (curricula != null) {
                alumno.setCurricula(curricula + student.getIdEspecialidad());
                alumno.setCreditos(getCreditos(student.getIdEspecialidad(), curricula));
            } else {
                alumno.setCurricula("");
                alumno.setCreditos(0);
            }
            alumno.setEspecialidad(speciality.map(speciality1 -> speciality1.getNombre()).orElse(null));
            alumno.setIdEspecialidad(student.getIdEspecialidad());
            alumno.setCorreo(student.getCodigo() + "@gmail.com");
            alumno.setDni(student.getCodigo());
            alumno.setFechaNacimiento("");
            alumno.setGenero("");
            alumno.setDomicilio("");
            alumno.setRol("EG");
            return alumno;
    }

}
