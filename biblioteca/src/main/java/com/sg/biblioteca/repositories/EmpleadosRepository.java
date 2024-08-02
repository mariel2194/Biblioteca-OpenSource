package com.sg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.biblioteca.models.Empleados;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {

}
