package com.unidad.deportiva.modulo.utilities;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.unidad.deportiva.modulo.models.HorasDirector;
import com.unidad.deportiva.modulo.repository.HorasDirectorDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Service

public class GenerarPDF {

    @Autowired
    HorasDirectorDAO horasDirectorDAO;

    Logger logger = LoggerFactory.getLogger(GenerarPDF.class);

    ArrayList<HorasDirector> horasPasantes = new ArrayList<>();

    public void generarPDFPasantes(HttpServletResponse response) throws IOException {

        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fontTitulo1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitulo1.setSize(19);

        Paragraph encabezado1 = new Paragraph("Modulo Unidad Deportiva 2022 - Miembros Pasantes" + "\n" + "\n" + "\n", fontTitulo1);
        encabezado1.setAlignment(Paragraph.ALIGN_CENTER);

        encabezado1.setAlignment(Paragraph.ALIGN_CENTER);
        Font fontTitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitulo.setSize(14);

        String certificados = "";

        try {
            HorasDirectorDAO dao = new HorasDirectorDAO();
            horasPasantes = dao.consultaPDFPasantes();
        }catch (Exception e){
            logger.info(e.toString());
        }

        logger.info("Entrar a mapear horas pasantes");
        for(HorasDirector hora:  horasPasantes){
            certificados += "Nombre Estudiante: " + hora.getNombre() + "\n";
            certificados +="Periodo: " + hora.getPeriodo()+ "\n";
            certificados +="Sede: " + hora.getSede()+ "\n";
            certificados += "Horas totales: " + hora.getHoras()+ "\n\n\n";
            logger.info(hora.toString());
        }

        Font fontparrafo = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontparrafo.setSize(12);
        Paragraph parrafo = new Paragraph(certificados, fontparrafo);
        parrafo.setAlignment(Paragraph.ALIGN_LEFT);

        documento.add(encabezado1);
        documento.add(parrafo);
        documento.close();

    }

    public void generarPDFMiembros(HttpServletResponse response) throws IOException {

        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fontTitulo1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitulo1.setSize(19);

        Paragraph encabezado1 = new Paragraph("Modulo Unidad Deportiva 2022 - Miembros Equipos" + "\n" + "\n" + "\n", fontTitulo1);
        encabezado1.setAlignment(Paragraph.ALIGN_CENTER);

        encabezado1.setAlignment(Paragraph.ALIGN_CENTER);
        Font fontTitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitulo.setSize(14);

        String certificados = "";

        try {
            HorasDirectorDAO dao = new HorasDirectorDAO();
            horasPasantes = dao.consultaPDFMiembros();
        }catch (Exception e){
            logger.info(e.toString());
        }

        logger.info("Entrar a mapear horas pasantes");
        for(HorasDirector hora:  horasPasantes){
            certificados += "Nombre Estudiante: " + hora.getNombre() + "\n";
            certificados +="Periodo: " + hora.getPeriodo()+ "\n";
            certificados +="Sede: " + hora.getSede()+ "\n";
            certificados += "Horas totales: " + hora.getHoras()+ "\n\n\n";
            logger.info(hora.toString());
        }

        Font fontparrafo = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontparrafo.setSize(12);
        Paragraph parrafo = new Paragraph(certificados, fontparrafo);
        parrafo.setAlignment(Paragraph.ALIGN_LEFT);

        documento.add(encabezado1);
        documento.add(parrafo);
        documento.close();

    }

}
