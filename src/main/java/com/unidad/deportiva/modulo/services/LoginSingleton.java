package com.unidad.deportiva.modulo.services;

import com.unidad.deportiva.modulo.models.Cargo;
import com.unidad.deportiva.modulo.models.Empleado;
import com.unidad.deportiva.modulo.models.Empleado_Cargo;
import com.unidad.deportiva.modulo.models.Espacio;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class LoginSingleton {

    static private LoginSingleton loginSingleton;
    private Empleado empleado;
    private Cargo cargo;
    private List<Espacio> espacio;

    public static LoginSingleton getService() {
        if (loginSingleton == null) {
            loginSingleton = new LoginSingleton();
        }
        return loginSingleton;
    }

}
