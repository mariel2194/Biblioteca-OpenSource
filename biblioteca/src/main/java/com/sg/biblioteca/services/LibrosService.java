package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Libros;
import com.sg.biblioteca.repositories.LibrosRepository;

@Service
public class LibrosService {

	 @Autowired
	    private LibrosRepository librosRepository;
	
	 //Return list of libros
	public List<Libros> ListLibros(){
		return librosRepository.findAll();
	}
	
}
