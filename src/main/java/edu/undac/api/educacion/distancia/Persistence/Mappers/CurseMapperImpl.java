package edu.undac.api.educacion.distancia.Persistence.Mappers;

import edu.undac.api.educacion.distancia.Domain.Curse;
import edu.undac.api.educacion.distancia.Persistence.Entities.Asignatura;
import edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper.CurseMapper;
import org.springframework.stereotype.Component;

@Component
public class CurseMapperImpl implements CurseMapper {

    @Override
    public Curse toCurse(Asignatura asignatura) {
        Curse curse = new Curse();
        curse.setCreditos(asignatura.getCreditos());
        curse.setIdCurricula(asignatura.getCodigoCurricula());
        curse.setIdCurso(asignatura.getCodigoAsignatura());
        curse.setIdEspecialidad(asignatura.getIdEspecialidad());
        return curse;
    }

    @Override
    public Asignatura toAsignatura(Curse curse) {
        return null;
    }
}
