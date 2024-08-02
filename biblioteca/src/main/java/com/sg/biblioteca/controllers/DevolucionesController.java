package com.sg.biblioteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DevolucionesController {

	@GetMapping("/devoluciones")
	public String getAutores() {
	return "devoluciones";
	}
}
