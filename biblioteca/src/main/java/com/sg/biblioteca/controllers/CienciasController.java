package com.sg.biblioteca.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.biblioteca.models.Ciencias;
import com.sg.biblioteca.models.Idiomas;
import com.sg.biblioteca.services.CienciasService;

@Controller
public class CienciasController {

	@Autowired
	private CienciasService cienciasService;
	
    private static final Logger logger = LoggerFactory.getLogger(CienciasController.class);


	@GetMapping("/ciencias")
	public String getCiencias(Model model) {
		List<Ciencias> cienciasList = cienciasService.ListCiencias();
		model.addAttribute("ciencias", cienciasList);
		return "ciencias";
	}

	@PostMapping("/ciencias/addnew")
	public String addNew(Ciencias ciencia, Model model) {
		try {
			cienciasService.saveNew(ciencia);
			return "redirect:/ciencias";
			
		} catch (Exception e) {
			logger.error("Error al guardar el ciencia", e);
			model.addAttribute("errorMessage", "Error al guardar el ciencia: " + e.getMessage());
			model.addAttribute("ciencia", ciencia);
			return "crearCiencia";
		}
	}

	// Método para manejar excepciones generales
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		logger.error("Error en el sistema", e);
		model.addAttribute("errorMessage", "Error en el sistema: " + e.getMessage());
		return "error"; // Página de error Thymeleaf
	}

	@GetMapping("/ciencias/edit/{id}")
	@ResponseBody
	public ResponseEntity<Ciencias> getEditCienciaesForm(@PathVariable("id") Integer id) {
		Ciencias ciencia = cienciasService.getCienciaById(id);
		if (ciencia == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(ciencia, HttpStatus.OK);
	}

	@PostMapping("/ciencias/update")
	public String updateCiencia(@ModelAttribute Ciencias ciencia) {
		cienciasService.updateCiencia(ciencia);
		return "redirect:/ciencias";
	}

	@PostMapping("/ciencias/delete/{id}")
	public String deleteCiencia(@PathVariable("id") Integer id) {
		cienciasService.deleteCiencia(id);
		return "redirect:/ciencias";
	}

}
