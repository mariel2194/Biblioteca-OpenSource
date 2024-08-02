package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Editoras;
import com.sg.biblioteca.services.EditorasService;

@Controller
public class EditorasController {
	
	@Autowired
	private EditorasService editorasService;

	@GetMapping("/editoras")
	public String getEditoras(Model model) {
		List<Editoras> editorasList = editorasService.ListEditoras();
		model.addAttribute("editoras", editorasList);
		return "editoras";
	}

}
