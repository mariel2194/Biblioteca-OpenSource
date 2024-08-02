package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Prestamos;
import com.sg.biblioteca.services.PrestamosService;

@Controller
public class PrestamosController {

	@Autowired
	private PrestamosService prestamosService;

	@GetMapping("/prestamos")
	public String getPrestamos(Model model) {
		List<Prestamos> prestamosList = prestamosService.ListPrestamos();
		model.addAttribute("prestamos", prestamosList);
		return "prestamos";
	}

}
