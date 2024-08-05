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
	
	public Autores getAutorById(Integer id) {
        return autoresRepository.findById(id).orElse(null);
    }
	
	
	//Save a new autor
	public void saveNew(Autores autor) {
		autoresRepository.save(autor);
	}

    public void updateAutor(Autores autor) {
        Autores existingAutor = autoresRepository.findById(autor.getId()).orElse(null);
        if (existingAutor != null) {
            existingAutor.setNombre(autor.getNombre());
            existingAutor.setPaisOrigen(autor.getPaisOrigen());
            existingAutor.setActivo(autor.getActivo());
            existingAutor.setIdioma(autor.getIdioma()); 
            autoresRepository.save(existingAutor);
        }
    }

    public void deleteAutor(Integer id) {
        autoresRepository.deleteById(id);
    }
	
	
	
}
