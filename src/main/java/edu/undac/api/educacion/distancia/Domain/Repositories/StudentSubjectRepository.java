package edu.undac.api.educacion.distancia.Domain.Repositories;

import edu.undac.api.educacion.distancia.Domain.StudentSubject;
import edu.undac.api.educacion.distancia.Persistence.Entities.AlumnoAsignatura;

import java.util.List;

public interface StudentSubjectRepository {

    List<StudentSubject> getByAlumno (String codigoAlumno);


}
