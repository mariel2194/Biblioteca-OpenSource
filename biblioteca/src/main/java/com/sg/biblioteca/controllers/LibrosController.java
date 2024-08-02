package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Libros;
import com.sg.biblioteca.services.LibrosService;

@Controller
public class LibrosController {

	@Autowired
	private LibrosService librosService;

	@GetMapping("/libros")
	public String getLibros(Model model) {
		List<Libros> librosList = librosService.ListLibros();
		model.addAttribute("libros", librosList);
		return "libros";
	}
}
