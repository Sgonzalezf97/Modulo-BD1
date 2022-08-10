package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Actividad;
import com.unidad.deportiva.modulo.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {

    @Autowired
    ActividadRepository actividadRepository;

    public List<Actividad> findAll() {
        return actividadRepository.findAll();
    }
}
