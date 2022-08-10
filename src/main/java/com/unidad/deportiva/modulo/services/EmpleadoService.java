package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Empleado;
import com.unidad.deportiva.modulo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Transactional
    public Object save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Empleado findById(String id) {
        return empleadoRepository.findByCodEmpleado(id);
    }

    public boolean existeEmpleado(String codEmpleado) {
        if(empleadoRepository.findById(codEmpleado).isPresent()){
            return true;
        }

        return false;

    }

    public Empleado findDocente(String nomEmpleado, String apellEmpleado){
        return empleadoRepository.findByNomEmpleadoAndApellEmpleado(nomEmpleado, apellEmpleado);
    }

}
