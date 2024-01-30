package edu.undac.api.educacion.distancia.Persistence.Mappers;

import edu.undac.api.educacion.distancia.Domain.StudentSubject;
import edu.undac.api.educacion.distancia.Persistence.Entities.AlumnoAsignatura;
import edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper.StudentSubjectMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentSubjectMapperImpl implements StudentSubjectMapper {

    @Override
    public StudentSubject toStudentSubject(AlumnoAsignatura alumnoAsignatura) {
        StudentSubject studentSubject = new StudentSubject();

        studentSubject.setAsignaturaCodigo(alumnoAsignatura.getCodigoAsignatura());
        studentSubject.setAlumnoCodigo(alumnoAsignatura.getCodigoAlumno());
        studentSubject.setAlumnoNota(alumnoAsignatura.getNotaAlumno());
        studentSubject.setPeriodoCodigo(alumnoAsignatura.getCodigoPeriodo());
        studentSubject.setCodigoCurricula(alumnoAsignatura.getCodigoCurricula());

        return studentSubject;
    }




    @Override
    public AlumnoAsignatura toAlumnoAsignatura(StudentSubject studentSubject) {
        return null;
    }

}
