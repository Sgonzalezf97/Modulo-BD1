package com.unidad.deportiva.modulo.controllers;

import com.unidad.deportiva.modulo.models.Cargo;
import com.unidad.deportiva.modulo.models.Empleado;
import com.unidad.deportiva.modulo.models.Empleado_Cargo;
import com.unidad.deportiva.modulo.models.Espacio;
import com.unidad.deportiva.modulo.services.*;
import com.unidad.deportiva.modulo.utilities.ConexionOracle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@Controller
@SessionAttributes("empleado_cargo")
public class LoginController{

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    EmpleadoCargoService empleadoCargoService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    CargoService cargoService;

    @Autowired
    EspacioService espacioService;

    @Autowired
    LoginService loginService;


    @GetMapping({"/login"})
    public String login(Model model) throws SQLException {
        model.addAttribute("empleado_cargo", new Empleado_Cargo());

        return "login";
    }

    @PostMapping("/login")
    public String loguearse(Empleado_Cargo empleado_cargo, RedirectAttributes flash) {

        boolean existeEmpleado = empleadoCargoService.validarEmpleado(empleado_cargo.getCodEmpleado(), empleado_cargo.getIdCargo());

        logger.info("Existe algun empleado con el id y y cargo seleccionado?:" + existeEmpleado);

        if (existeEmpleado) {

            logger.info("El idCargo es:" + empleado_cargo.getIdCargo());

            Empleado empleado = empleadoService.findById(empleado_cargo.getCodEmpleado());
            Cargo cargo = cargoService.findById(Long.valueOf(empleado_cargo.getIdCargo()));
            List<Espacio> espacios = espacioService.findById(empleado_cargo.getCodEmpleado());

            if(empleado == null || cargo == null || espacios == null){
                return "redirect:/login";
            }

            loginService.iniciarSesion(empleado, cargo, espacios);

            switch (empleado_cargo.getIdCargo()) {
                case "1" -> {
                    flash.addFlashAttribute("success", "Bienvenido Auxiliar");
                    return "redirect:/auxiliar";
                }
                case "3" -> {
                    flash.addFlashAttribute("success", "Bienvenido Director");
                    return "redirect:/director";
                }
                default -> {
                    if(!empleadoService.existeEmpleado(empleado_cargo.getCodEmpleado())){
                        flash.addFlashAttribute("error", "El usuario no existe");
                    } else{
                        String mensajeFlash = (empleado_cargo.getIdCargo() == "1")? "El usuario no es un Auxiliar" : "El usuario no es un Director Deportivo";
                        flash.addFlashAttribute("error", mensajeFlash);
                    }
                    return "redirect:/login";
                }
            }
        } else {
            return "redirect:/login";
        }

    }



}
