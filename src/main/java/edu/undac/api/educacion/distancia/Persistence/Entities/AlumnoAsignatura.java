package edu.undac.api.educacion.distancia.Persistence.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos_asignaturas")
public class AlumnoAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idAlumnoAsignatura;

    @Column(name = "per_codi")
    private String codigoPeriodo;

    @Column(name = "alu_codi")
    private String codigoAlumno;

    @Column(name = "myc_nota")
    private Integer notaAlumno;

    @Column(name = "esp_codi")
    private String idEspecialidad;

    @Column(name = "asi_codi")
    private String codigoAsignatura;

    @Column(name = "cur_codi")
    private String codigoCurricula;

    //Getters and Setters

    public Integer getIdAlumnoAsignatura() {
        return idAlumnoAsignatura;
    }

    public void setIdAlumnoAsignatura(Integer idAlumnoAsignatura) {
        this.idAlumnoAsignatura = idAlumnoAsignatura;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public Integer getNotaAlumno() {
        return notaAlumno;
    }

    public void setNotaAlumno(Integer notaAlumno) {
        this.notaAlumno = notaAlumno;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public String getCodigoCurricula() {
        return codigoCurricula;
    }

    public void setCodigoCurricula(String codigoCurricula) {
        this.codigoCurricula = codigoCurricula;
    }
}
