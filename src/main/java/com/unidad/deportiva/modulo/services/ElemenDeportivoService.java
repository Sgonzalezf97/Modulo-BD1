package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.ElemenDeportivo;
import com.unidad.deportiva.modulo.repository.ElemenDeportivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElemenDeportivoService {

    @Autowired
    ElemenDeportivoRepository elemenDeportivoRepository;

    public List<ElemenDeportivo> findAll(){
        return elemenDeportivoRepository.findAll();
    }

}
