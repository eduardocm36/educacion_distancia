package edu.undac.api.educacion.distancia.Domain.Repositories;

import edu.undac.api.educacion.distancia.Domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Optional<Student> getAlumno(String code);


}
