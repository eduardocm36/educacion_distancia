package edu.undac.api.educacion.distancia.Persistence.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idAsignatura;

    @Column(name = "asi_codi")
    private String codigoAsignatura;

    @Column(name = "asi_nomb")
    private String nombre;

    @Column(name = "asi_cred")
    private Integer creditos;

    @Column(name = "Cur_codi")
    private String codigoCurricula;

    @Column(name = "Asi_equi")
    private String asiEqui;

    @Column(name = "Esp_codi")
    private String idEspecialidad;

    @Column(name = "Sed_codi")
    private Integer sedeCodigo;

    // Getters and Setters

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getCodigoCurricula() {
        return codigoCurricula;
    }

    public void setCodigoCurricula(String codigoCurricula) {
        this.codigoCurricula = codigoCurricula;
    }

    public String getAsiEqui() {
        return asiEqui;
    }

    public void setAsiEqui(String asiEqui) {
        this.asiEqui = asiEqui;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getSedeCodigo() {
        return sedeCodigo;
    }

    public void setSedeCodigo(Integer sedeCodigo) {
        this.sedeCodigo = sedeCodigo;
    }
}
