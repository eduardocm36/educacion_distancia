package edu.undac.api.educacion.distancia.Domain.Repositories;

import edu.undac.api.educacion.distancia.Domain.Curse;

import java.util.List;
import java.util.Optional;

public interface CurseRepository {

    Optional<List<Curse>> getByEspecialidadCurricula(String especialidad, String curricula);

}
