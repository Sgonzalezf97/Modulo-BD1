package com.unidad.deportiva.modulo.models;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "CARGO")
public class Cargo {

    @Id
    @NotNull
    @Column(name = "IDCARGO")
    private String idCargo;

    @NotNull
    @Column(name = "DESCARGO")
    private String desCargo;

}

