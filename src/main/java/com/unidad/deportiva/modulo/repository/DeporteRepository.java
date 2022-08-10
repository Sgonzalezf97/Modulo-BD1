package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeporteRepository extends JpaRepository<Deporte, String> {


}
