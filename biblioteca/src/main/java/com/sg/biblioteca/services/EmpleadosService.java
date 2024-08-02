package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Empleados;
import com.sg.biblioteca.repositories.EmpleadosRepository;

@Service
public class EmpleadosService {
	 @Autowired
	    private EmpleadosRepository empleadosRepository;
	
	 //Return list of empleados
	public List<Empleados> ListEmpleados(){
		return empleadosRepository.findAll();
	}
}
