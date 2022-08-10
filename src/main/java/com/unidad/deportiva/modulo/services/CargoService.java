package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Cargo;
import com.unidad.deportiva.modulo.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    @Autowired
    CargoRepository cargoRepository;

    public Cargo findById(Long idCargo) {

        return cargoRepository.findByIdCargo(idCargo);
    }
}
