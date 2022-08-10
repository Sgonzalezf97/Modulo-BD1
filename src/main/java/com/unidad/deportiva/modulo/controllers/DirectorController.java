package com.unidad.deportiva.modulo.controllers;

import com.unidad.deportiva.modulo.models.*;
import com.unidad.deportiva.modulo.repository.HorasDirectorDAO;
import com.unidad.deportiva.modulo.services.LoginSingleton;
import com.unidad.deportiva.modulo.utilities.GenerarPDF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
public class DirectorController {

    @Autowired
    GenerarPDF generarPDF;

    Logger logger = LoggerFactory.getLogger(AuxiliarController.class);

    @GetMapping({"/director"})
    public String indexDirector(Model model) throws FileNotFoundException {

        try {
            HorasDirectorDAO dao = new HorasDirectorDAO();
            dao.consultaPDFPasantes();
            dao.consultaPDFMiembros();
            System.out.println("Exitosa");
        }catch (Exception e){
            System.out.println("Error");
        }

        Empleado empleado = LoginSingleton.getService().getEmpleado();
        Cargo cargo = LoginSingleton.getService().getCargo();
        List<Espacio> espacio = LoginSingleton.getService().getEspacio();

        model.addAttribute("espacios", espacio);
        model.addAttribute("cargo", cargo);
        model.addAttribute("empleado", empleado);

        return "director";
    }

    @GetMapping("/horasPasantes")
    public void generarHorasPasante(Model model, HttpServletResponse response) throws IOException {

        logger.info("Entrar a generar PDF Pasantes");
        response.setContentType("prueba/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Horas Pasantes Unidad Deportiva.pdf";
        response.setHeader(headerKey, headerValue);
        this.generarPDF.generarPDFPasantes(response);

    }

    @GetMapping("/horasMiembros")
    public void generarHorasMiembros(Model model, HttpServletResponse response) throws IOException {

        logger.info("Entrar a generar PDF Miembros");
        response.setContentType("prueba/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Horas Miembros Equipos Unidad Deportiva.pdf";
        response.setHeader(headerKey, headerValue);
        this.generarPDF.generarPDFMiembros(response);
    }


}
