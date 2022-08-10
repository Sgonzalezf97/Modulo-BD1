package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Deporte;
import com.unidad.deportiva.modulo.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService {

    @Autowired
    DeporteRepository deporteRepository;

    public List<Deporte> findAll() {
        return deporteRepository.findAll();
    }
}
