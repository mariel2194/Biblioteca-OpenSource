package com.sg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.biblioteca.models.Devoluciones;

@Repository
public interface DevolucionesRepository extends JpaRepository<Devoluciones, Integer> {

	boolean existsByPrestamoId(Integer prestamoId);
}
