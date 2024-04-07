package edu.undac.api.educacion.distancia.DTO.Exceptions;

public class DistanceException extends Exception{

    private ExceptionDetails details;

    public DistanceException(String message, ExceptionDetails details) {
        super(message);
        this.details = details;
    }

    public DistanceException(String message, Throwable cause, ExceptionDetails details) {
        super(message, cause);
        this.details = details;
    }

    public ExceptionDetails getDetails() {
        return details;
    }

    public void setDetails(ExceptionDetails details) {
        this.details = details;
    }
}
