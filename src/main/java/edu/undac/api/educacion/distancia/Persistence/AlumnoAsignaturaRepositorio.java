package edu.undac.api.educacion.distancia.Persistence;

import edu.undac.api.educacion.distancia.Domain.Repositories.StudentSubjectRepository;
import edu.undac.api.educacion.distancia.Domain.StudentSubject;
import edu.undac.api.educacion.distancia.Persistence.CRUD.AlumnoAsignaturaCrudRepository;
import edu.undac.api.educacion.distancia.Persistence.Entities.AlumnoAsignatura;
import edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper.StudentSubjectMapper;
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


    @Override
    public Optional<List<StudentSubject>> getByAlumno(String codigoAlumno) {
        Optional<List<AlumnoAsignatura>> alumnoAsignaturas = alumnoAsignaturaCrudRepository.findByCodigoAlumno(codigoAlumno);
        return alumnoAsignaturas.map(alumnos -> alumnos
                .stream().map(alumno -> mapper.toStudentSubject(alumno)).toList()).or(() -> Optional.empty());
    }
}
