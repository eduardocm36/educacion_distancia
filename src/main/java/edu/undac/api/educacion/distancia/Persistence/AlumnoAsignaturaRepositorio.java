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

@Repository
public class AlumnoAsignaturaRepositorio implements StudentSubjectRepository {

    @Autowired
    private AlumnoAsignaturaCrudRepository alumnoAsignaturaCrudRepository;

    @Autowired
    private StudentSubjectMapper mapper;


    @Override
    public List<StudentSubject> getByAlumno(String codigoAlumno) {
        List<StudentSubject> studentSubjects = new ArrayList<>();
        List<AlumnoAsignatura> alumnoAsignaturas = alumnoAsignaturaCrudRepository.findByCodigoAlumno(codigoAlumno);
        for(AlumnoAsignatura alumnoAsignatura : alumnoAsignaturas) {
            studentSubjects.add(mapper.toStudentSubject(alumnoAsignatura));
        }
        return studentSubjects;
    }
}
