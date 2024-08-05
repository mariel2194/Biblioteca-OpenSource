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
	

	public Libros getLibroById(Integer id) {
        return librosRepository.findById(id).orElse(null);
    }
	
	
	//Save a new autor
	public void saveNew(Libros autor) {
		librosRepository.save(autor);
	}

    public void updateLibro(Libros libro) {
        Libros existingLibro = librosRepository.findById(libro.getId()).orElse(null);
        if (existingLibro != null) {
            existingLibro.setDescripcion(libro.getDescripcion());
            existingLibro.setAnioPublicacion(libro.getAnioPublicacion());
            existingLibro.setAutor(libro.getAutor());
            existingLibro.setEditora(libro.getEditora());
            existingLibro.setISBN(libro.getISBN());
            existingLibro.setEdicion(libro.getEdicion());
            existingLibro.setCantidad(libro.getCantidad());
            existingLibro.setIdioma(libro.getIdioma());
            existingLibro.setSignaturaTipografica(libro.getSignaturaTipografica());
            existingLibro.setCiencia(libro.getCiencia());
            existingLibro.setActivo(libro.isActivo());
            librosRepository.save(existingLibro);
        }
    }

    public void deleteLibro(Integer id) {
        librosRepository.deleteById(id);
    }
	
	
	
}
