package com.unidad.deportiva.modulo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "EQUIPO")
public class Equipo {

    @Id
    @NotNull
    @Column(name = "CONSECEQUIPO")
    private Number consecEquipo;

    @NotNull
    @Column(name = "CODEMPLEADO")
    private String codEmpleado;

    @NotNull
    @Column(name = "IDDEPORTE")
    private String idDeporte;

    @DateTimeFormat
    @NotNull
    @Column(name = "FECHARESOL")
    private Date fechaResol;



}
