package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "RESPONSABLE")
public class Responsable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "CONSECPROGRA")
    private Long consecProgra;

    @NotNull
    @Column(name = "CONSECRES")
    private Long consecRes;

    @NotNull
    @Column(name = "IDROL")
    private String idRol;

    @NotNull
    @Column(name = "CODESTUDIANTE")
    private String codEstudiante;

    @NotNull
    @Column(name = "CODEMPLEADO")
    private String codEmpleado;

    @NotNull
    @Column(name = "FECHAINI")
    private Date FechaIni;

    @NotNull
    @Column(name = "FECHAFIN")
    private Date fechaFin;



}
