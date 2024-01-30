package edu.undac.api.educacion.distancia.Domain.Repositories;

import edu.undac.api.educacion.distancia.Domain.Student;

public interface StudentRepository {

    Student getAlumno(String code);


}
