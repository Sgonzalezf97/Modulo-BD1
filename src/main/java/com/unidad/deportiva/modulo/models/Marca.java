package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "DEPORTEESPACIO")
public class Marca {
    @Id
    @NotNull
    @Column(name = "IDMARCA")
    private String idMarca;

    @NotNull
    @Column(name = "NOMMARCA")
    private String nomMarca;
}
