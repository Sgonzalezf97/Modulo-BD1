package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.Empleado;
import com.unidad.deportiva.modulo.models.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio, String> {
    @Query(value = "SELECT * FROM EMPLEADO E, EMPLEADO_CARGO EC, ESPACIO ES, CARGO C WHERE E.CODEMPLEADO=EC.CODEMPLEADO AND ES.CODESPACIO=EC.CODESPACIO AND C.IDCARGO=EC.IDCARGO AND E.CODEMPLEADO = ?1",
            nativeQuery = true)
    List<Espacio> findByCodEmpleado(String codEmpleado);


}
