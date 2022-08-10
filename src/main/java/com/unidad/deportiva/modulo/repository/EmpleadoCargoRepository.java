package com.unidad.deportiva.modulo.repository;


import com.unidad.deportiva.modulo.models.Empleado_Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoCargoRepository extends JpaRepository<Empleado_Cargo, String> {

    @Query(value = "SELECT * FROM EMPLEADO_CARGO ec WHERE ec.CODEMPLEADO = ?1 AND ec.IDCARGO = ?2", nativeQuery = true)
    List<Empleado_Cargo> findByCodEmpleadoAndIdCargo(String codEmpleado, String idCargo);


    @Query(value = "SELECT * FROM EMPLEADO_CARGO ec WHERE ec.CODEMPLEADO = ?1", nativeQuery = true)
    Empleado_Cargo findByCodEmpleado(String codEmpleado);
}
