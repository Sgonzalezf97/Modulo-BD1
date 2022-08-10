package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Responsable;
import com.unidad.deportiva.modulo.repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsableService {

    @Autowired
    ResponsableRepository responsableRepository;
    public List<Responsable> findAll() {
        return responsableRepository.findAll();
    }

    public Responsable findByCodEmpleado(String codEmpleado) {
        return  responsableRepository.findByCodEmpleado(codEmpleado);
    }
}
