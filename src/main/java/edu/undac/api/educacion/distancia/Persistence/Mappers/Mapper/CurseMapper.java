package edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper;

import edu.undac.api.educacion.distancia.Domain.Curse;
import edu.undac.api.educacion.distancia.Persistence.Entities.Asignatura;

public interface CurseMapper {

    Curse toCurse (Asignatura asignatura);

    Asignatura toAsignatura (Curse curse);


}
