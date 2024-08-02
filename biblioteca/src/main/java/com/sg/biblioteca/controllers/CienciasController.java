package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Ciencias;
import com.sg.biblioteca.services.CienciasService;

@Controller
public class CienciasController {

	@Autowired
	private CienciasService cienciasService;

	@GetMapping("/ciencias")
	public String getCiencias(Model model) {
		List<Ciencias> cienciasList = cienciasService.ListCiencias();
		model.addAttribute("ciencias", cienciasList);
		return "ciencias";
	}
}
