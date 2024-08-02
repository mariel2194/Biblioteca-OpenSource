package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Prestamos;
import com.sg.biblioteca.repositories.PrestamosRepository;

@Service
public class PrestamosService {

	 @Autowired
	    private PrestamosRepository prestamosRepository;
	
	 //Return list of prestamos
	public List<Prestamos> ListPrestamos(){
		return prestamosRepository.findAll();
	}
}
