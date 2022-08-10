package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable,Long> {


    @Query(value = "SELECT * FROM RESPONSABLE R WHERE R.CODEMPLEADO = ?1", nativeQuery = true)
    Responsable findByCodEmpleado(String codEmpleado);
}
