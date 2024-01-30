package edu.undac.api.educacion.distancia.Domain;

public class Speciality {

    private String id;
    private String nombre;
    private String idEscuela;
    private int sedeCodigo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(String idEscuela) {
        this.idEscuela = idEscuela;
    }

    public int getSedeCodigo() {
        return sedeCodigo;
    }

    public void setSedeCodigo(int sedeCodigo) {
        this.sedeCodigo = sedeCodigo;
    }
}
