package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

    @Query(value = "SELECT * FROM ESTUDIANTE WHERE CODESTUDIANTE = ?1", nativeQuery = true)
    Estudiante findByCodEstudiante(String codEstudiante);


}
