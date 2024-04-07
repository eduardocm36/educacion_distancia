package edu.undac.api.educacion.distancia.Persistence.CRUD;

import edu.undac.api.educacion.distancia.Persistence.Entities.AlumnoAsignatura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlumnoAsignaturaCrudRepository extends CrudRepository<AlumnoAsignatura, Integer> {

    Optional<List<AlumnoAsignatura>> findByCodigoAlumno (String codigoAlumno);

}
