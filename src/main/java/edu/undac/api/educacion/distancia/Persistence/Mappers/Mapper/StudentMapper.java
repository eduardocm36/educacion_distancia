package edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper;

import edu.undac.api.educacion.distancia.Domain.Student;
import edu.undac.api.educacion.distancia.Persistence.Entities.Alumno;

public interface StudentMapper {

    Student toStudent(Alumno alumno);

    Alumno toAlumno(Student student);

}
