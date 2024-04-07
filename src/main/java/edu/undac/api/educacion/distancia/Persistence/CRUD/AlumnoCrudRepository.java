package edu.undac.api.educacion.distancia.Persistence.CRUD;

import edu.undac.api.educacion.distancia.Persistence.Entities.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface AlumnoCrudRepository extends CrudRepository<Alumno, Integer> {

    Optional<Alumno> findByCodigo (String codigo);
}
