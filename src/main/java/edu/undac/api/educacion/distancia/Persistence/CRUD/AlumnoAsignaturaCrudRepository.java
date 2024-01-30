package edu.undac.api.educacion.distancia.Persistence.CRUD;

import edu.undac.api.educacion.distancia.Persistence.Entities.AlumnoAsignatura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlumnoAsignaturaCrudRepository extends CrudRepository<AlumnoAsignatura, Integer> {

    List<AlumnoAsignatura> findByCodigoAlumno (String codigoAlumno);

}
