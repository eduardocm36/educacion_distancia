package edu.undac.api.educacion.distancia.Domain.Repositories;

import edu.undac.api.educacion.distancia.Domain.Speciality;

import java.util.Optional;

public interface SpecialityRepository {

    Optional<Speciality> getById(String id);

}
