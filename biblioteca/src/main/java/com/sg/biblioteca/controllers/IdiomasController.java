package com.sg.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	 @PostMapping("/idiomas/delete/{id}")
	    public String deleteIdioma(@PathVariable("id") Integer id) {
	        idiomasService.deleteIdioma(id);
	        return "redirect:/idiomas";
	    }

	    @PostMapping("/idiomas/update")
	    public String updateIdioma(@ModelAttribute Idiomas idioma) {
	        idiomasService.updateIdioma(idioma);
	        return "redirect:/idiomas";
	    }
}
