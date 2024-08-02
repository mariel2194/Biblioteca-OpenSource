package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Editoras;
import com.sg.biblioteca.repositories.EditorasRepository;

@Service
public class EditorasService {

	 @Autowired
	    private EditorasRepository editorasRepository;
	
	 //Return list of editoras
	public List<Editoras> ListEditoras(){
		return editorasRepository.findAll();
	}
}
