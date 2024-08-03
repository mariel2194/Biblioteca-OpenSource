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

	// Return list of Idiomas
	public List<Idiomas> ListIdiomas() {
		return idiomasRepository.findAll();
	}

	public Idiomas getIdiomaById(Integer id) {
        return idiomasRepository.findById(id).orElse(null);
    }

	public void updateIdioma(Idiomas idioma) {
        Idiomas existingIdioma = idiomasRepository.findById(idioma.getId()).orElse(null);
        if (existingIdioma != null) {
            existingIdioma.setDescripcion(idioma.getDescripcion());
            existingIdioma.setActivo(idioma.isActivo());
            idiomasRepository.save(existingIdioma);
        }
    }

    public void deleteIdioma(Integer id) {
        idiomasRepository.deleteById(id);
    }

}
