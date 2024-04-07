package edu.undac.api.educacion.distancia.Domain.Repositories;

import edu.undac.api.educacion.distancia.Domain.StudentSubject;
import edu.undac.api.educacion.distancia.Persistence.Entities.AlumnoAsignatura;

import java.util.List;
import java.util.Optional;

public interface StudentSubjectRepository {

    Optional<List<StudentSubject>> getByAlumno (String codigoAlumno);


}
