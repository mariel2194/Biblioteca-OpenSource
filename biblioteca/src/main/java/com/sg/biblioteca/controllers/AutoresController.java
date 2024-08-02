package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Autores;
import com.sg.biblioteca.services.AutoresService;

@Controller
public class AutoresController {

	@Autowired
	private AutoresService autoresService;

	@GetMapping("/autores")
	public String getAutores(Model model) {
		List<Autores> autoresList = autoresService.ListAutores();
		model.addAttribute("autores", autoresList);
		return "autores";
	}

}
