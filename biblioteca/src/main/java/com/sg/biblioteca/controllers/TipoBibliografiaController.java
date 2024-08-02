package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.TipoBibliografia;
import com.sg.biblioteca.services.TipoBibliografiaService;

@Controller
public class TipoBibliografiaController {

	@Autowired
	private TipoBibliografiaService tipoBibliografiaService;

	@GetMapping("/tipoBibliografia")
	public String getTipoBibliografia(Model model) {
		List<TipoBibliografia> tipoBibliografiaList = tipoBibliografiaService.ListTipoBibliografia();
		model.addAttribute("tipoBibliografia", tipoBibliografiaList);
		return "tipoBibliografia";
	}
}
