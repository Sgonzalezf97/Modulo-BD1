package com.unidad.deportiva.modulo.repository;


import com.unidad.deportiva.modulo.models.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramacionRepository extends JpaRepository<Programacion, Long> {




}
