package com.sg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.biblioteca.models.Autores;

@Repository
public interface AutoresRepository extends JpaRepository<Autores, Integer> {

}
