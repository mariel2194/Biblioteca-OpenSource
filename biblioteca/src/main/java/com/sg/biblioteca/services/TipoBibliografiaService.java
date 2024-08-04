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
	
	public TipoBibliografia getTipoBibliografiaById(Integer id) {
        return tipoBibliografiaRepository.findById(id).orElse(null);
    }
	
	
	//Save a new tipoBibliografia
	public void saveNew(TipoBibliografia tipoBibliografia) {
		tipoBibliografiaRepository.save(tipoBibliografia);
	}

    public void updateTipoBibliografia(TipoBibliografia tipoBibliografia) {
        TipoBibliografia existingTipoBibliografia = tipoBibliografiaRepository.findById(tipoBibliografia.getId()).orElse(null);
        if (existingTipoBibliografia != null) {
            existingTipoBibliografia.setDescripcion(tipoBibliografia.getDescripcion());
            existingTipoBibliografia.setActivo(tipoBibliografia.isActivo());
            tipoBibliografiaRepository.save(existingTipoBibliografia);
        }
    }

    public void deleteTipoBibliografia(Integer id) {
        tipoBibliografiaRepository.deleteById(id);
    }
	
}
