package edu.undac.api.educacion.distancia.Domain;

public class Curse {

    private String idCurso;
    private int creditos;
    private String idCurricula;
    private String idEspecialidad;

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getIdCurricula() {
        return idCurricula;
    }

    public void setIdCurricula(String idCurricula) {
        this.idCurricula = idCurricula;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
}
