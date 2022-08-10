package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "TIPOELEMENTO")
public class TipoElemento {

    @Id
    @NotNull
    @Column(name = "IDTIPOELEMENTO")
    private String idTipoElmento;

    @NotNull
    @Column(name = "DESCTIPOELEMENTO")
    private String descTipoElmento;
}
