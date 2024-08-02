package com.sg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.biblioteca.models.Idiomas;

@Repository
public interface IdiomasRepository extends JpaRepository<Idiomas, Integer> {

}
