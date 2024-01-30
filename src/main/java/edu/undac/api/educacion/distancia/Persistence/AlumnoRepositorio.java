package edu.undac.api.educacion.distancia.Persistence;

import edu.undac.api.educacion.distancia.Domain.Student;
import edu.undac.api.educacion.distancia.Domain.Repositories.StudentRepository;
import edu.undac.api.educacion.distancia.Persistence.CRUD.AlumnoCrudRepository;
import edu.undac.api.educacion.distancia.Persistence.Entities.Alumno;
import edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlumnoRepositorio implements StudentRepository {

    @Autowired
    private AlumnoCrudRepository alumnoCrudRepository;

    @Autowired
    private StudentMapper mapper;

    @Override
    public Student getAlumno(String code) {
        Alumno alumno = alumnoCrudRepository.findByCodigo(code);
         return mapper.toStudent(alumno);
    }
}
