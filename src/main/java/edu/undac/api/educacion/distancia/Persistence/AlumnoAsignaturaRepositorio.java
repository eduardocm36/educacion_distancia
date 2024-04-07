package edu.undac.api.educacion.distancia.Persistence;

import edu.undac.api.educacion.distancia.Domain.Repositories.StudentSubjectRepository;
import edu.undac.api.educacion.distancia.Domain.StudentSubject;
import edu.undac.api.educacion.distancia.Persistence.CRUD.AlumnoAsignaturaCrudRepository;
import edu.undac.api.educacion.distancia.Persistence.Entities.AlumnoAsignatura;
import edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper.StudentSubjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlumnoAsignaturaRepositorio implements StudentSubjectRepository {

    @Autowired
    private AlumnoAsignaturaCrudRepository alumnoAsignaturaCrudRepository;

    @Autowired
    private StudentSubjectMapper mapper;

    private static Logger LOG = LoggerFactory.getLogger(AlumnoAsignaturaRepositorio.class);


    @Override
    public Optional<List<StudentSubject>> getByAlumno(String codigoAlumno) {
        Optional<List<AlumnoAsignatura>> alumnoAsignaturas = alumnoAsignaturaCrudRepository.findByCodigoAlumno(codigoAlumno);
        return alumnoAsignaturas.map(alumnos -> alumnos
                .stream().map(alumno -> mapper.toStudentSubject(alumno)).toList()).or(() -> {
                    LOG.warn("No existe matrículas para este usuario");
                    return Optional.empty();
        });
    }
}
