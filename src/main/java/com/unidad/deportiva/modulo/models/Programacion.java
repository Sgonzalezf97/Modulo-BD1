package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "PROGRAMACION")
public class Programacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "CONSECPROGRA")
    private Long consecProgra;

    @NotNull
    @Column(name = "IDDIA")
    private String idDia;

    @NotNull
    @Column(name = "IDHORA")
    private String idHora;

    @NotNull
    @Column(name = "CODESPACIO")
    private String codEspacio;

    @NotNull
    @Column(name = "HOR_IDHORA")
    private String hor_idHora;

    @NotNull
    @Column(name = "IDACTIVIDAD")
    private String idActividad;

    @NotNull
    @Column(name = "IDDEPORTE")
    private String idDeporte;

    @NotNull
    @Column(name = "IDPERIODO")
    private String idPeriodo;

    @NotNull
    @Column(name = "CUPO")
    private Long cupo;

    @NotNull
    @Column(name = "NOINSCRITO")
    private Long noInscrito;



}
