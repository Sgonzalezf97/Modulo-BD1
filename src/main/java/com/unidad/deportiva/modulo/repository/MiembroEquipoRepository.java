package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.MiembroEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MiembroEquipoRepository extends JpaRepository<MiembroEquipo, Long> {

    @Query(value = "SELECT * FROM MIEMBROEQUIPO WHERE CODESTUDIANTE = ?1 AND CONSECEQUIPO =?2", nativeQuery = true)
    MiembroEquipo findByCodEstudianteAndEquipo(String codEstudiante, Long consecEquipo);
}
