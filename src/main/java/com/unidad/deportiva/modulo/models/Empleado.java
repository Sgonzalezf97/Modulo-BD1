package com.unidad.deportiva.modulo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODEMPLEADO")
    private String codEmpleado;

    @NotNull
    @Column(name = "NOMEMPLEADO")
    private String nomEmpleado;

    @NotNull
    @Column(name = "APELLEMPLEADO")
    private String apellEmpleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "FECHAREGISTROEMP")
    private Date fechaRegistroEmp;

    @NotNull
    @Email
    @Column(name = "CORREOUD")
    private String correoUd;



}