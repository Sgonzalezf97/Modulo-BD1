package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "DEPORTE")
public class Deporte {

    @Id
    @NotNull
    @Column(name = "IDDEPORTE")
    private String idDeporte;

    @NotNull
    @Column(name = "NOMDEPORTE")
    private String nomDeporte;
}
