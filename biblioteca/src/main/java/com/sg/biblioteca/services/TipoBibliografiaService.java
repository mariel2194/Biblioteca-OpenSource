package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.TipoBibliografia;
import com.sg.biblioteca.repositories.TipoBibliografiaRepository;

@Service
public class TipoBibliografiaService {

	 @Autowired
	    private TipoBibliografiaRepository tipoBibliografiaRepository;
	
	 //Return list of tipoBibliografia
	public List<TipoBibliografia> ListTipoBibliografia(){
		return tipoBibliografiaRepository.findAll();
	}
}
