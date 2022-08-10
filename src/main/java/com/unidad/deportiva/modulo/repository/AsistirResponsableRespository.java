package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.AsistirResponsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistirResponsableRespository extends JpaRepository<AsistirResponsable, Long> {


}
