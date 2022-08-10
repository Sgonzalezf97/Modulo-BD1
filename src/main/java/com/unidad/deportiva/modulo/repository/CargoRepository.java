package com.unidad.deportiva.modulo.repository;

import com.unidad.deportiva.modulo.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    @Query(value = "SELECT * FROM CARGO ca WHERE ca.IDCARGO = ?1", nativeQuery = true)
    Cargo findByIdCargo(Long idCargo);
}
