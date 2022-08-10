package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "ACTIVIDAD")
public class Actividad {

    @Id
    @NotNull
    @Column(name = "IDACTIVIDAD")
    private String idActividad;

    @NotNull
    @Column(name = "DESCACTIVIDAD")
    private String descActividad;

}
