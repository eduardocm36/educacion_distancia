package edu.undac.api.educacion.distancia.Persistence.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "escuelas_distancia")
public class Escuela {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "esc_codi")
    private String idEscuela;

    @Column(name = "fac_codi")
    private Integer facultadCodigo;

    @Column(name = "esc_nomb")
    private String nombre;

    @Column(name = "sed_codi")
    private Integer sedeCodigo;

    @OneToMany(mappedBy = "escuela")
    private List<Especialidad> especialidades;

    //Getters and Setters

    public String getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(String idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
}
