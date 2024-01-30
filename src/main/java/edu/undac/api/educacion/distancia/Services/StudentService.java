package edu.undac.api.educacion.distancia.Services;

import edu.undac.api.educacion.distancia.Domain.Repositories.StudentSubjectRepository;
import edu.undac.api.educacion.distancia.Domain.Speciality;
import edu.undac.api.educacion.distancia.Domain.Student;
import edu.undac.api.educacion.distancia.Domain.Repositories.SpecialityRepository;
import edu.undac.api.educacion.distancia.Domain.Repositories.StudentRepository;
import edu.undac.api.educacion.distancia.Domain.StudentSubject;
import edu.undac.api.educacion.distancia.Models.AlumnoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    private String getCurricula(String alumno) {
        List<StudentSubject> matriculados = studentSubjectRepository.getByAlumno(alumno);
        if (matriculados.size() == 0){
            return null;
        } else {
            String curricula = matriculados.get(0).getCodigoCurricula();
            for (StudentSubject studentSubject : matriculados) {
                if (!curricula.equals(studentSubject.getCodigoCurricula())) {
                    return null;
                }
            }
            return curricula;
        }
    }

    public AlumnoResponse getStudent (String code){
        AlumnoResponse alumno = new AlumnoResponse();
        Student student = studentRepository.getAlumno(code);
        Optional<Speciality> speciality = specialityRepository.getById(student.getIdEspecialidad());
        String apellidos = student.getNombre().split(", ")[0];
        alumno.setNombres(student.getNombre().split(", ")[1]);
        alumno.setApePaterno(apellidos.split(" ")[0]);
        alumno.setApeMaterno(apellidos.split(" ")[1]);
        if (getCurricula(student.getCodigo()) != null){
            alumno.setCurricula(getCurricula(student.getCodigo()) + student.getIdEspecialidad());
        } else {
            alumno.setCurricula("");
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
