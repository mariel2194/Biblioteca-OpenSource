package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Empleados;
import com.sg.biblioteca.services.EmpleadosService;

@Controller
public class EmpleadosController {

	@Autowired
	private EmpleadosService empleadosService;

	@GetMapping("/empleados")
	public String getEmpleados(Model model) {
		List<Empleados> empleadosList = empleadosService.ListEmpleados();
		model.addAttribute("empleados", empleadosList);
		return "empleados";
	}

}
