package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.sg.biblioteca.models.Usuarios;
import com.sg.biblioteca.services.UsuariosService;

@Controller

public class UsuariosController {

	@Autowired
	private UsuariosService usuariosService;

	@GetMapping("/usuarios")
	public String getUsuarios(Model model) {
		List<Usuarios> usuariosList = usuariosService.ListUsuarios();
		model.addAttribute("usuarios", usuariosList);
		return "usuarios";
	}
		
	
}
