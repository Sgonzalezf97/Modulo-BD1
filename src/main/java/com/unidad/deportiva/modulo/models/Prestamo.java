package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "PRESTAMO")
public class Prestamo {

    @Id
    @NotNull
    @Column(name = "CONSECPRESTAMO")
    private Long consecPrestamo;

    @NotNull
    @Column(name = "CONSECELEMENTO")
    private Long consecElemento;

    @NotNull
    @Column(name = "CONSECPROGRA")
    private Long consecProgra;

    @NotNull
    @Column(name = "CONSECRES")
    private Long consecRes;

    @NotNull
    @Column(name = "CONSECASISRES")
    private Long consecAsisRes;

}
