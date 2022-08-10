package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Estudiante;
import com.unidad.deportiva.modulo.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    public Estudiante findByCodEstudiante(String codEstudiante){
        return estudianteRepository.findByCodEstudiante(codEstudiante);
    }

}
