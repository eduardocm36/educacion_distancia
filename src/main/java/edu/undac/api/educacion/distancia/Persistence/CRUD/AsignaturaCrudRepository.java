package edu.undac.api.educacion.distancia.Persistence.CRUD;

import edu.undac.api.educacion.distancia.Persistence.Entities.Asignatura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface AsignaturaCrudRepository extends CrudRepository<Asignatura, Integer> {

    Optional<List<Asignatura>> findByIdEspecialidadAndCodigoCurricula (String idEspecialidad, String codigoCurrricula);

}
