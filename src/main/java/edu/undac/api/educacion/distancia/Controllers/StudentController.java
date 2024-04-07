package edu.undac.api.educacion.distancia.Controllers;

import edu.undac.api.educacion.distancia.DTO.Exceptions.DistanceException;
import edu.undac.api.educacion.distancia.DTO.Exceptions.ExceptionDetails;
import edu.undac.api.educacion.distancia.DTO.Responses.AlumnoResponse;
import edu.undac.api.educacion.distancia.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{code}")
    public ResponseEntity<AlumnoResponse> getByCode(@PathVariable("code") String code) throws DistanceException {
        Optional<AlumnoResponse> alumnoResponse = studentService.getAlumnoFromAPI(code);
        Boolean condition = alumnoResponse.filter(alumnoResponse1 -> alumnoResponse1.getCurricula() == null).isPresent();
        if (condition){
            alumnoResponse = studentService.getStudent(code);
        }
        return alumnoResponse.map(alumnoResponse1 -> new ResponseEntity<>(alumnoResponse1, HttpStatus.OK))
                .orElseThrow(() -> new DistanceException("El código ingresado no existe",
                        new ExceptionDetails("Codigo inexistente", HttpStatus.NOT_FOUND.value())));
    }

}
