package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Idiomas;
import com.sg.biblioteca.repositories.IdiomasRepository;

@Service
public class IdiomasService {

	@Autowired
	   private IdiomasRepository idiomasRepository;
		
		 //Return list of Idiomas
		public List<Idiomas> ListIdiomas(){
			return idiomasRepository.findAll();
		}

}
