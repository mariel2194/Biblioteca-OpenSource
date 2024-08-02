package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Empleados;
import com.sg.biblioteca.models.Libros;
import com.sg.biblioteca.models.Usuarios;
import com.sg.biblioteca.services.EmpleadosService;
import com.sg.biblioteca.services.LibrosService;
import com.sg.biblioteca.services.UsuariosService;

@Controller
public class LibrosController {

	@Autowired
	private LibrosService librosService;
	@Autowired
	private UsuariosService usuariosService;
	
	@Autowired
	private EmpleadosService empleadosService;

	@GetMapping("/libros")
	public String getLibros(Model model) {
		List<Libros> librosList = librosService.ListLibros();
		List<Usuarios> usuariosList = usuariosService.ListUsuarios();
		List<Empleados> empleadosList = empleadosService.ListEmpleados();
		model.addAttribute("empleados", empleadosList);
		model.addAttribute("libros", librosList);
		model.addAttribute("usuarios", usuariosList);

		return "libros";
	}
}
