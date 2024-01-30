package edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper;


import edu.undac.api.educacion.distancia.Persistence.Entities.AlumnoAsignatura;
import edu.undac.api.educacion.distancia.Domain.StudentSubject;

public interface StudentSubjectMapper {

    StudentSubject toStudentSubject(AlumnoAsignatura alumnoAsignatura);

    AlumnoAsignatura toAlumnoAsignatura (StudentSubject studentSubject);

}
