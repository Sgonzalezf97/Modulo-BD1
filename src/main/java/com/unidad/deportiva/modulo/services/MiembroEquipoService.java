package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.MiembroEquipo;
import com.unidad.deportiva.modulo.repository.MiembroEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiembroEquipoService {

    @Autowired
    MiembroEquipoRepository miembroEquipoRepository;

    public MiembroEquipo findByCodEstudianteAndEquipo(String codEstudiante, Long consecEquipo) {
        return miembroEquipoRepository.findByCodEstudianteAndEquipo(codEstudiante, consecEquipo);
    }
}
