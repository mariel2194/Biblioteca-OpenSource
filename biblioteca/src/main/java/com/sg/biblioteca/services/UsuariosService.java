package com.sg.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Usuarios;
import com.sg.biblioteca.repositories.UsuariosRepository;

@Service
public class UsuariosService {

	 @Autowired
	 private UsuariosRepository usuariosRepository;
	
	 //Return list of usuarios
	public List<Usuarios> ListUsuarios(){
		return usuariosRepository.findAll();
	}
}
