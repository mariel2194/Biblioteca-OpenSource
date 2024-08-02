package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Devoluciones;
import com.sg.biblioteca.repositories.DevolucionesRepository;

@Service
public class DevolucionesService {
	
	 @Autowired
	    private DevolucionesRepository devolucionesRepository;
	
	 //Return list of devoluciones
	public List<Devoluciones> ListDevoluciones(){
		return devolucionesRepository.findAll();
	}

}
