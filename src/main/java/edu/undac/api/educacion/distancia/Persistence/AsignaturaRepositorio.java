package edu.undac.api.educacion.distancia.Persistence;

import edu.undac.api.educacion.distancia.Domain.Curse;
import edu.undac.api.educacion.distancia.Domain.Repositories.CurseRepository;
import edu.undac.api.educacion.distancia.Persistence.CRUD.AsignaturaCrudRepository;
import edu.undac.api.educacion.distancia.Persistence.Entities.Asignatura;
import edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper.CurseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AsignaturaRepositorio implements CurseRepository {

    @Autowired
    private AsignaturaCrudRepository asignaturaCrudRepository;

    @Autowired
    private CurseMapper curseMapper;

    @Override
    public Optional<List<Curse>> getByEspecialidadCurricula(String especialidad, String curricula) {
        Optional<List<Asignatura>> asignaturas = asignaturaCrudRepository.findByIdEspecialidadAndCodigoCurricula(especialidad, curricula);
        Optional<List<Curse>> curses = asignaturas.map(asignaturas1 -> asignaturas1.stream()
                .map(asignatura -> curseMapper.toCurse(asignatura)).toList());
        return curses;
    }
}
