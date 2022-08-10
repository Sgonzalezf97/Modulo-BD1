package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class HorasDirector {

    @Id
    private String codEstudiante;

    private Long horas;
    private String nombre;
    private String periodo;
    private String sede;

}
