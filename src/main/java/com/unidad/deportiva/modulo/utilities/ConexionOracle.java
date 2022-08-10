package com.unidad.deportiva.modulo.utilities;

import com.unidad.deportiva.modulo.repository.HorasDirectorDAO;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Data
public class ConexionOracle {

    private static ConexionOracle instance = null;

    /**
     * Conexion compartida a la Base de Datos
     */
    private Connection conexion = null;

    /**
     * Bandera que indica el estado de la conexion
     */
    private boolean conexionLibre = true;

    Logger logger = LoggerFactory.getLogger(HorasDirectorDAO.class);

    /**
     * @return instancia del ServiceLocator para el manejo de la conexion
     */
    public static ConexionOracle getInstance() {
        if (instance == null) {
            try {
                instance = new ConexionOracle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    /**
     * @throws Exception dice si no se pudo crear la conexion
     */
    public ConexionOracle() throws Exception {
        try {
            // Se registra el Driver y se crea la conexion
            //String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String usuario = "ancjimenezm";
            String password = "pass"; //Debe reemplazarse por el password en su propia instalación
            Class.forName("oracle.jdbc.OracleDriver");
            conexion = (Connection) DriverManager.getConnection(url, usuario, password);
            logger.info("Exitosa");
        } catch (Exception e) {
            logger.info("Error");
            System.out.println("Error Conexion");
        }
    }

    /**
     * Toma la conexion para que ningun otro proceso la puedan utilizar
     *
     * @return da la conexion a la base de datos
     */
    public synchronized Connection tomarConexion() {
        while (!conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = false;
        notify();
        return conexion;
    }

    /**
     * Libera la conexion de la bases de datos para que ningun otro proceso la
     * pueda utilizar
     */
    public synchronized void liberarConexion() {
        while (conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = true;
        notify();
    }

    /**
     * Cierra la conexion a la base de datos cuando se termina de ejecutar el
     * programa
     */
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Realiza los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza cuando el procedimiento de insercion es terminado
     * correctamente y se asegura que los datos en el modelo estan bien
     * relacionados.
     */
    public void commit() {
        try {
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deshace los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza por lo general cuando se devuelve una Exepcion. Los
     * procedimientos intermedios no deberia quedar almacenados en la base de
     * datos.
     */
    public void rollback() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
