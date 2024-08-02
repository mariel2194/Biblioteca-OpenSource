package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Devoluciones;
import com.sg.biblioteca.services.DevolucionesService;

@Controller
public class DevolucionesController {
	@Autowired
	private DevolucionesService devolucionesService;

	@GetMapping("/devoluciones")
	public String getDevoluciones(Model model) {
		List<Devoluciones> devolucionesList = devolucionesService.ListDevoluciones();
		model.addAttribute("devoluciones", devolucionesList);
		return "devoluciones";
	}
}
