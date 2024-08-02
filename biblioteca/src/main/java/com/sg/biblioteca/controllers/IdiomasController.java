package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Idiomas;
import com.sg.biblioteca.services.IdiomasService;

@Controller
public class IdiomasController {

	@Autowired
	private IdiomasService idiomasService;

	@GetMapping("/idiomas")
	public String getIdiomas(Model model) {
		List<Idiomas> idiomasList = idiomasService.ListIdiomas();
		model.addAttribute("idiomas", idiomasList);
		return "idiomas";
	}
}
