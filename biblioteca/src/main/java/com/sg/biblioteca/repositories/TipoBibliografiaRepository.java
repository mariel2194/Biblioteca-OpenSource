package com.sg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.biblioteca.models.TipoBibliografia;


@Repository
public interface TipoBibliografiaRepository extends JpaRepository<TipoBibliografia, Integer> {

}
