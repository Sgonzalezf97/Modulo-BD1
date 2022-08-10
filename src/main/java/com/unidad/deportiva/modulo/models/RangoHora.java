package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class RangoHora {

    @Id
    private String id;

    private String curso;

    private String espacio;

    private String nomDeporte;

    private String codEspacio;

    private Long inscritos;

}
