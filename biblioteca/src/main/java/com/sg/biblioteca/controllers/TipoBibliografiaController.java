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

import com.sg.biblioteca.models.TipoBibliografia;
import com.sg.biblioteca.services.TipoBibliografiaService;

@Controller
public class TipoBibliografiaController {

	@Autowired
	private TipoBibliografiaService tipoBibliografiaService;
	
    private static final Logger logger = LoggerFactory.getLogger(TipoBibliografiaController.class);


	@GetMapping("/tipoBibliografia")
	public String getTipoBibliografia(Model model) {
		List<TipoBibliografia> tipoBibliografiaList = tipoBibliografiaService.ListTipoBibliografia();
		model.addAttribute("tipoBibliografia", tipoBibliografiaList);
		return "tipoBibliografia";
	}
	

	@PostMapping("/tipoBibliografia/addnew")
	public String addNew(TipoBibliografia tipoBibliografia, Model model) {
		try {
			tipoBibliografiaService.saveNew(tipoBibliografia);
			return "redirect:/tipoBibliografia";
			
		} catch (Exception e) {
			logger.error("Error al guardar el ciencia", e);
			model.addAttribute("errorMessage", "Error al guardar el tipoBibliografia: " + e.getMessage());
			model.addAttribute("tipoBibliografia", tipoBibliografia);
			return "crearTipoBibliografia";
		}
	}

	// Método para manejar excepciones generales
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		logger.error("Error en el sistema", e);
		model.addAttribute("errorMessage", "Error en el sistema: " + e.getMessage());
		return "error"; // Página de error Thymeleaf
	}

	@GetMapping("/tipoBibliografia/edit/{id}")
	@ResponseBody
	public ResponseEntity<TipoBibliografia> getEditTipoBibliografiaesForm(@PathVariable("id") Integer id) {
		TipoBibliografia tipoBibliografia = tipoBibliografiaService.getTipoBibliografiaById(id);
		if (tipoBibliografia == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tipoBibliografia, HttpStatus.OK);
	}

	@PostMapping("/tipoBibliografia/update")
	public String updateTipoBibliografia(@ModelAttribute TipoBibliografia tipoBibliografia) {
		tipoBibliografiaService.updateTipoBibliografia(tipoBibliografia);
		return "redirect:/tipoBibliografia";
	}

	@PostMapping("/tipoBibliografia/delete/{id}")
	public String deleteTipoBibliografia(@PathVariable("id") Integer id) {
		tipoBibliografiaService.deleteTipoBibliografia(id);
		return "redirect:/tipoBibliografia";
	}
}
