package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    @Query(value = "SELECT * FROM EMPLEADO em WHERE em.CODEMPLEADO = ?1", nativeQuery = true)
    Empleado findByCodEmpleado(String codEmpleado);

    @Query(value = "SELECT * FROM EMPLEADO em WHERE LOWER(em.NOMEMPLEADO) = LOWER(?1) AND LOWER(em.APELLEMPLEADO) = LOWER(?2)", nativeQuery = true)
    Empleado findByNomEmpleadoAndApellEmpleado(String nomEmpleado, String apellEmpleado);


}
