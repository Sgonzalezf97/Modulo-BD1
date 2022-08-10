package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, String> {


}
