package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Empleado_Cargo;
import com.unidad.deportiva.modulo.repository.EmpleadoCargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoCargoService {
    
    @Autowired
    EmpleadoCargoRepository empleadoCargoRepository;

    public boolean validarEmpleado(String codEmpleado, String idCargo) {
        if (empleadoCargoRepository.findByCodEmpleadoAndIdCargo(codEmpleado, idCargo).isEmpty()){
            return false;
        }
        return true;
    }

    public Empleado_Cargo findByCodEmpleado(String codEmpleado) {
        return empleadoCargoRepository.findByCodEmpleado(codEmpleado);
    }
}
