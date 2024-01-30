package edu.undac.api.educacion.distancia.Persistence.CRUD;

import edu.undac.api.educacion.distancia.Persistence.Entities.Alumno;
import org.springframework.data.repository.CrudRepository;


public interface AlumnoCrudRepository extends CrudRepository<Alumno, Integer> {

    Alumno findByCodigo (String codigo);
}
