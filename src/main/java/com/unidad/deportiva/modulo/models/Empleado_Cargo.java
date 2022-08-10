package com.unidad.deportiva.modulo.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "EMPLEADO_CARGO")
public class Empleado_Cargo {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "CONSEC")
    private Long consec;

    @NotNull
    @Column(name = "CODEMPLEADO")
    private String codEmpleado;

    @NotNull
    @Column(name = "IDCARGO")
    private String idCargo;

    @NotNull
    @Column(name = "CODESPACIO")
    private String codEspacio;

    @DateTimeFormat
    @NotNull
    @Column(name = "FECHACARGO")
    private Date fechaCargo;

    @DateTimeFormat
    @Column(name = "FECHAFINCAR")
    private Date fechaFinCar;
}

