package com.sg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.biblioteca.models.Prestamos;

@Repository
public interface PrestamosRepository extends JpaRepository<Prestamos, Integer> {

}
