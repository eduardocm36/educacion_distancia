package edu.undac.api.educacion.distancia.Persistence.Mappers;

import edu.undac.api.educacion.distancia.Domain.Speciality;
import edu.undac.api.educacion.distancia.Persistence.Entities.Especialidad;
import edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper.SpecialityMapper;
import org.springframework.stereotype.Component;

@Component
public class SpecialityMapperImpl implements SpecialityMapper {

    @Override
    public Speciality toSpeciality(Especialidad especialidad) {
        Speciality speciality = new Speciality();
        speciality.setId(especialidad.getIdEscuela());
        speciality.setNombre(especialidad.getNombre());
        speciality.setIdEscuela(especialidad.getIdEscuela());
        speciality.setSedeCodigo(especialidad.getSedeCodigo());
        return speciality;
    }

    @Override
    public Especialidad toEspecialidad(Speciality speciality) {
        // mapper toEspecialidad
        return null;
    }
}
