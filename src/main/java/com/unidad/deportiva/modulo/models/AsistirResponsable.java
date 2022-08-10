package com.unidad.deportiva.modulo.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "ASISTIRRESPONSABLE")
public class AsistirResponsable {

    @Id
    @NotNull
    @Column(name = "CONSECASISRES")
    private Long consecAsisRes;

    @NotNull
    @Column(name = "CONSECPROGRA")
    private Long consecProgra;

    @NotNull
    @Column(name = "IDACTIVIDAD")
    private String idActividad;

    @NotNull
    @Column(name = "CONSECRES")
    private Long consecRes;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "FECHAASISRES")
    private Date fechaAsisRes;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "HORAASISRES")
    private Date horaAsisRes;
}
