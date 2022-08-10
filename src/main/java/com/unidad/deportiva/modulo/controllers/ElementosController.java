package com.unidad.deportiva.modulo.controllers;

import com.unidad.deportiva.modulo.models.Cargo;
import com.unidad.deportiva.modulo.models.Empleado;
import com.unidad.deportiva.modulo.models.Espacio;
import com.unidad.deportiva.modulo.services.LoginSingleton;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ElementosController {

    @GetMapping("/indexElementosDeportivos")
    public String indexAuxiliar(Model model) {

        Empleado empleado = LoginSingleton.getService().getEmpleado();
        Cargo cargo = LoginSingleton.getService().getCargo();
        List<Espacio> espacio = LoginSingleton.getService().getEspacio();

        model.addAttribute("espacios", espacio);
        model.addAttribute("cargo", cargo);
        model.addAttribute("empleado", empleado);
        return "indexElementosDeportivos";
    }

}
