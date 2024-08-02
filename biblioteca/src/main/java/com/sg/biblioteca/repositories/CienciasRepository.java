package com.sg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.biblioteca.models.Ciencias;

@Repository
public interface CienciasRepository extends JpaRepository<Ciencias, Integer> {

}
