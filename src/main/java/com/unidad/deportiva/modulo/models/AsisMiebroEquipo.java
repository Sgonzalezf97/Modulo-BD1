package com.unidad.deportiva.modulo.models;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name = "ASISMIEMBROEQUIPO")
public class AsisMiebroEquipo {

    @Id
    @NotNull
    @Column(name = "CONSECPOGRAM")
    private Long consecPogram;

    @NotNull
    @Column(name = "CONMIEMEQUIPO")
    private Long conMiemEquipo;

    @NotNull
    @Column(name = "CONSECEQUIPO")
    private Long consecEquipo;

    @NotNull
    @Column(name = "ITEMMIEMBRO")
    private Long itemMiembro;

}
