package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Cargo;
import com.unidad.deportiva.modulo.models.Empleado;
import com.unidad.deportiva.modulo.models.Espacio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    public void iniciarSesion(Empleado empleado, Cargo cargo, List<Espacio> espacio) {
        LoginSingleton.getService().setEmpleado(empleado);
        LoginSingleton.getService().setCargo(cargo);
        LoginSingleton.getService().setEspacio(espacio);
    }
}
