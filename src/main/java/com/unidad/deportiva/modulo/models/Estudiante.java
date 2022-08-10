package com.unidad.deportiva.modulo.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "ESTUDIANTE")
public class Estudiante {

    @Id
    @NotNull
    @Column(name = "CODESTUDIANTE")
    private String codEstudiante;

    @NotNull
    @Column(name = "CODESPACIO")
    private String codEspacio;

    @NotNull
    @Column(name = "NOMESTU")
    private String nomEstu;

    @NotNull
    @Column(name = "APELLESTU")
    private String apellEstu;

    @DateTimeFormat
    @NotNull
    @Column(name = "FECHAREGESTU")
    private Date fechaRegEstu;

    @NotNull
    @Column(name = "CORREOUDESTU")
    private String correoUdEstu;

    @DateTimeFormat
    @NotNull
    @Column(name = "FECHANACESTU")
    private Date fechaNacEstu;
}
