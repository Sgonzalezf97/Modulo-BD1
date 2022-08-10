package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.ElemenDeportivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElemenDeportivoRepository extends JpaRepository<ElemenDeportivo, Long> {



}
