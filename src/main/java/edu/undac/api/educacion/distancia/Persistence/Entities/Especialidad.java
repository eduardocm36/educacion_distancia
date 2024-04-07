package edu.undac.api.educacion.distancia.Persistence.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "especialidades_distancia")
public class Especialidad {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "esp_codi")
    private String idEspecialidad;

    @Column(name = "esp_nomb")
    private String nombre;

    @Column(name = "esc_codi")
    private String idEscuela;

    @Column(name = "fac_codi")
    private Integer facultadCodigo;

    @Column(name = "sed_codi")
    private Integer sedeCodigo;

    @OneToMany(mappedBy = "especialidad")
    private List<Alumno> alumnos;

    @ManyToOne
    @JoinColumn(name = "esc_codi", insertable=false, updatable=false)
    private Escuela escuela;

    //Getters and Setters

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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

    public Integer getFacultadCodigo() {
        return facultadCodigo;
    }

    public void setFacultadCodigo(Integer facultadCodigo) {
        this.facultadCodigo = facultadCodigo;
    }

    public Integer getSedeCodigo() {
        return sedeCodigo;
    }

    public void setSedeCodigo(Integer sedeCodigo) {
        this.sedeCodigo = sedeCodigo;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }
}
