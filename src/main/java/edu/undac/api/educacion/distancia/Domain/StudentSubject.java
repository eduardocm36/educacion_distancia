package edu.undac.api.educacion.distancia.Domain;

public class StudentSubject {

    private String asignaturaCodigo;
    private String alumnoCodigo;
    private int alumnoNota;
    private String periodoCodigo;
    private String codigoCurricula;

    public String getPeriodoCodigo() {
        return periodoCodigo;
    }

    public void setPeriodoCodigo(String periodoCodigo) {
        this.periodoCodigo = periodoCodigo;
    }

    public String getAlumnoCodigo() {
        return alumnoCodigo;
    }

    public void setAlumnoCodigo(String alumnoCodigo) {
        this.alumnoCodigo = alumnoCodigo;
    }

    public int getAlumnoNota() {
        return alumnoNota;
    }

    public void setAlumnoNota(int alumnoNota) {
        this.alumnoNota = alumnoNota;
    }

    public String getAsignaturaCodigo() {
        return asignaturaCodigo;
    }

    public void setAsignaturaCodigo(String asignaturaCodigo) {
        this.asignaturaCodigo = asignaturaCodigo;
    }

    public String getCodigoCurricula() {
        return codigoCurricula;
    }

    public void setCodigoCurricula(String codigoCurricula) {
        this.codigoCurricula = codigoCurricula;
    }
}
