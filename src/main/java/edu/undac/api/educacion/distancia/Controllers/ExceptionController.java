package edu.undac.api.educacion.distancia.Controllers;

import edu.undac.api.educacion.distancia.DTO.Exceptions.DistanceException;
import edu.undac.api.educacion.distancia.DTO.Exceptions.ExceptionDetails;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionController.class.getName());

    @ExceptionHandler(DistanceException.class)
    public ResponseEntity<ExceptionDetails> exceptionHandler (DistanceException exception){
        LOG.error(exception.getMessage());
        return new ResponseEntity<>(exception.getDetails(), HttpStatusCode.valueOf(exception.getDetails().getCode()));
    }

    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<ExceptionDetails> moreSpeciality (IncorrectResultSizeDataAccessException exception){
        LOG.error(exception.getMessage());
        return new ResponseEntity<>(new ExceptionDetails("Usuario con más de una matricula"
                , HttpStatus.INTERNAL_SERVER_ERROR.value()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
