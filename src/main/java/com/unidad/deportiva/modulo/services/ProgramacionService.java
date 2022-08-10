package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Programacion;
import com.unidad.deportiva.modulo.repository.ProgramacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramacionService {

    @Autowired
    ProgramacionRepository programacionRepository;

    public List<Programacion> findAll() {
        return programacionRepository.findAll();
    }
}
