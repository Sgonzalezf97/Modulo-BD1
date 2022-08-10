package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="ESTADO")
public class Estado {
    @Id
    @NotNull
    @Column (name="IDESTADO")
    private String idEstado;

    @NotNull
    @Column (name="DESCESTADO")
    private String descEstado;

}
