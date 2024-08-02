package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Ciencias;
import com.sg.biblioteca.repositories.CienciasRepository;

@Service
public class CienciasService {
	
	@Autowired
	   private CienciasRepository cienciasRepository;
		
		 //Return list of autores
		public List<Ciencias> ListCiencias(){
			return cienciasRepository.findAll();
		}

}
