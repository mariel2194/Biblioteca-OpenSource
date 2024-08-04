package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Ciencias;
import com.sg.biblioteca.models.Ciencias;
import com.sg.biblioteca.repositories.CienciasRepository;

@Service
public class CienciasService {
	
	@Autowired
	   private CienciasRepository cienciasRepository;
		
		 //Return list of ciencia
		public List<Ciencias> ListCiencias(){
			return cienciasRepository.findAll();
		}
		
		public Ciencias getCienciaById(Integer id) {
	        return cienciasRepository.findById(id).orElse(null);
	    }
		
		
		//Save a new ciencia
		public void saveNew(Ciencias ciencia) {
			cienciasRepository.save(ciencia);
		}

	    public void updateCiencia(Ciencias ciencia) {
	        Ciencias existingCiencia = cienciasRepository.findById(ciencia.getId()).orElse(null);
	        if (existingCiencia != null) {
	            existingCiencia.setDescripcion(ciencia.getDescripcion());
	            existingCiencia.setActivo(ciencia.isActivo());
	            cienciasRepository.save(existingCiencia);
	        }
	    }

	    public void deleteCiencia(Integer id) {
	        cienciasRepository.deleteById(id);
	    }
		

}
