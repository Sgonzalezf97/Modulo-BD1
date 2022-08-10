package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Espacio;
import com.unidad.deportiva.modulo.repository.EspacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacioService {
    
    @Autowired
    EspacioRepository espacioRepository;
    
    public List<Espacio>
    findById(String codEmpleado) {
        return espacioRepository.findByCodEmpleado(codEmpleado);
    }

    public List<Espacio> findAll() {
        return espacioRepository.findAll();
    }
}
