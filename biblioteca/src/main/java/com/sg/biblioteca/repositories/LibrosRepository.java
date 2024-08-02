package com.sg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.biblioteca.models.Libros;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Integer> {

}
