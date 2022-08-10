package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="INSCRITOPRACLIBRE")
public class InscritoPracLibre {

    @Id
    @NotNull
    @Column(name = "CONSEC")
    private Long consec;
}
