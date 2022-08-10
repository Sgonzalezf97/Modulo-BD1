package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.AsistirResponsable;
import com.unidad.deportiva.modulo.repository.AsistirResponsableRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistirResponsaleService {

    @Autowired
    AsistirResponsableRespository asistirResponsableRespository;

    public AsistirResponsable save(AsistirResponsable asistirResponsable) {
        return asistirResponsableRespository.save(asistirResponsable);
    }
}
