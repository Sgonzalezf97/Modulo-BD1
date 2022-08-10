package com.unidad.deportiva.modulo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "ROL")
public class Rol {
    @Id
    @NotNull
    @Column(name = "IDROL")
    private String idRol;

    @NotNull
    @Column(name = "DESCROL")
    private String descRol;
}
