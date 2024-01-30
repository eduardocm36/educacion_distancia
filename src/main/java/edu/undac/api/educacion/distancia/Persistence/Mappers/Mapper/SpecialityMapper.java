package edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper;

import edu.undac.api.educacion.distancia.Domain.Speciality;
import edu.undac.api.educacion.distancia.Persistence.Entities.Especialidad;

public interface SpecialityMapper {

    Speciality toSpeciality (Especialidad especialidad);

    Especialidad toEspecialidad (Speciality speciality);



}
