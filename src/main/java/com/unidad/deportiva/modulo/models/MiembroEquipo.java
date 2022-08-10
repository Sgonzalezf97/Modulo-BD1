package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "MIEMBROEQUIPO")
public class MiembroEquipo {

    @Id
    @NotNull
    @Column(name = "CONSECEQUIPO")
    private Long consecEquipo;

    @NotNull
    @Column(name = "ITEMMIEMBRO")
    private Long itemMiembro;

    @NotNull
    @Column(name = "CODESTUDIANTE")
    private String codEstudiante;
}
