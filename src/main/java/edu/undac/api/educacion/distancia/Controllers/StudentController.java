package edu.undac.api.educacion.distancia.Controllers;

import edu.undac.api.educacion.distancia.Domain.Student;
import edu.undac.api.educacion.distancia.Models.AlumnoResponse;
import edu.undac.api.educacion.distancia.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{code}")
    public ResponseEntity<AlumnoResponse> getByCode(@PathVariable("code") String code){
        return new ResponseEntity<>(studentService.getStudent(code), HttpStatus.OK);
    }

}
