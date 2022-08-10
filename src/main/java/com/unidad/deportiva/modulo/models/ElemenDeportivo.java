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
@Table(name = "ELEMENDEPORTIVO")
public class ElemenDeportivo {

    @Id
    @NotNull
    @Column(name = "CONSECELEMENTO")
    private Long consecPogram;

    @NotNull
    @Column(name = "IDTIPOELEMENTO")
    private String idTipoElemento;

    @NotNull
    @Column(name = "IDESTADO")
    private String idEstado;

    @NotNull
    @Column(name = "CODESPACIO")
    private String codEspacio;

    @NotNull
    @Column(name = "IDMARCA")
    private String idMarca;

    @DateTimeFormat
    @NotNull
    @Column(name = "FECHAREGISTRO")
    private Date fechaRegistro;
}
