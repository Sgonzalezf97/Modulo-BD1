package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "ESPACIO")
public class Espacio {
    @Id
    @NotNull
    @Column(name = "CODESPACIO")
    private String codEspacio;


    @Column(name = "ESP_CODESPACIO")
    private String esp_codEspacio;

    @NotNull
    @Column(name = "IDTIPOESPACIO")
    private String idTipoEspacio;

    @NotNull
    @Column(name = "NOMESPACIO")
    private String nomEspacio;
}
