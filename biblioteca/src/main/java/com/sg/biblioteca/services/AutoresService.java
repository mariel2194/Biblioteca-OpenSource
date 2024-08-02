package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Autores;
import com.sg.biblioteca.repositories.AutoresRepository;

@Service
public class AutoresService {

	 @Autowired
	    private AutoresRepository autoresRepository;
	
	 //Return list of autores
	public List<Autores> ListAutores(){
		return autoresRepository.findAll();
	}
	
}
