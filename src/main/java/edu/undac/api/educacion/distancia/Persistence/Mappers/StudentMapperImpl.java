package edu.undac.api.educacion.distancia.Persistence.Mappers;

import edu.undac.api.educacion.distancia.Domain.Student;
import edu.undac.api.educacion.distancia.Persistence.Entities.Alumno;
import edu.undac.api.educacion.distancia.Persistence.Mappers.Mapper.StudentMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toStudent(Alumno alumno) {
        Student student = new Student();

        student.setId(alumno.getIdAlumno());
        student.setCodigo(alumno.getCodigo());
        student.setNombre(alumno.getNombres());
        student.setIdEspecialidad(alumno.getIdEspecialidad());
        return student;
    }

    @Override
    public Alumno toAlumno(Student student) {
        Alumno alumno = new Alumno();
        alumno.setIdAlumno(student.getId());
        alumno.setNombres(student.getNombre());
        alumno.setCodigo(student.getCodigo());
        alumno.setIdEspecialidad(student.getIdEspecialidad());
        alumno.setCurricula(student.getCurricula());
        return alumno;
    }
}
