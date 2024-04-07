package edu.undac.api.educacion.distancia.DTO.Responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlumnoResponse {

    @JsonProperty("Apellido paterno")
    private String apePaterno;
    @JsonProperty("Apellido materno")
    private String apeMaterno;
    @JsonProperty("Nombres")
    private String nombres;
    @JsonProperty("Correo Institucional")
    private String correo;// codigo@undac.edu.pe
    @JsonProperty("Dni")
    private String dni; //codigo
    @JsonProperty("Curricula")
    private String curricula;
    @JsonProperty("Fecha de nacimiento")
    private String fechaNacimiento; //null
    @JsonProperty("Programa facultad")
    private String especialidad;
    private int creditos;
    @JsonProperty("ID_ESCUELA")
    private String idEspecialidad;
    @JsonProperty("Genero")
    private String genero; //
    @JsonProperty("Domicilio")
    private String domicilio; //""
    @JsonProperty("Rol")
    private String rol; //EG

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCurricula() {
        return curricula;
    }

    public void setCurricula(String curricula) {
        this.curricula = curricula;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
