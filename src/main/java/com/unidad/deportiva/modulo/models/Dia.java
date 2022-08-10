package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "DIA")
public class Dia {

    @Id
    @NotNull
    @Column(name = "IDDIA")
    private String idDia;

    @NotNull
    @Column(name = "NOMDIA")
    private String nomDia;

}
