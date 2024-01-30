package edu.undac.api.educacion.distancia.Persistence;

import edu.undac.api.educacion.distancia.Domain.Speciality;
import edu.undac.api.educacion.distancia.Domain.Repositories.SpecialityRepository;
import edu.undac.api.educacion.distancia.Persistence.CRUD.EspecialidadCrudRepository;
import edu.undac.api.educacion.distancia.Persistence.Entities.Especialidad;
import edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper.SpecialityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EspecialidadRepositorio implements SpecialityRepository {

    @Autowired
    private EspecialidadCrudRepository especialidadCrudRepository;

    @Autowired
    private SpecialityMapper mapper;

    @Override
    public Optional<Speciality> getById(String id) {
        Optional<Especialidad> especialidad = especialidadCrudRepository.findById(id);
        return especialidad.map(especialidad1 -> mapper.toSpeciality(especialidad1));
    }
}
