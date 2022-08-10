package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "HORA")
public class Hora {

    @Id
    @NotNull
    @Column(name = "IDHORA")
    private String idHora;

}
