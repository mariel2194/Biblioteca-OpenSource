package com.sg.biblioteca.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sg.biblioteca.models.Autores;
import com.sg.biblioteca.models.Idiomas;
import com.sg.biblioteca.services.AutoresService;
import com.sg.biblioteca.services.IdiomasService;

@Controller
public class AutoresController {

	@Autowired
	private AutoresService autoresService;
	
	@Autowired
	private IdiomasService idiomasService;
	
    private static final Logger logger = LoggerFactory.getLogger(AutoresController.class);

	

	 @GetMapping("/autores")
	    public String getAutores(Model model) {
	        List<Autores> autoresList = autoresService.ListAutores();
	        List<Idiomas> idiomasList = idiomasService.ListIdiomas();
	        model.addAttribute("autores", autoresList);
	        model.addAttribute("idiomas", idiomasList);
	        
	        return "autores";
	    }
	
	 @PostMapping("/autores/addnew")
	    public String addNew(Autores autor, Model model) {
	        try {
	            autoresService.saveNew(autor);
	            return "redirect:/autores";
	        } catch (Exception e) {
	            logger.error("Error al guardar el autor", e);
	            model.addAttribute("errorMessage", "Error al guardar el autor: " + e.getMessage());
	            model.addAttribute("autor", autor);
	            List<Idiomas> idiomasList = idiomasService.ListIdiomas();
	            model.addAttribute("idiomas", idiomasList);
	            return "crearAutor";
	        }
	    }

	    // Método para manejar excepciones generales
	    @ExceptionHandler(Exception.class)
	    public String handleException(Exception e, Model model) {
	        logger.error("Error en el sistema", e);
	        model.addAttribute("errorMessage", "Error en el sistema: " + e.getMessage());
	        return "error"; // Página de error Thymeleaf
	    }
	
	    @GetMapping("/autores/edit/{id}")
	    @ResponseBody
	    public ResponseEntity<Autores> getEditAutoresForm(@PathVariable("id") Integer id) {
	        Autores autor = autoresService.getAutorById(id);
	        if (autor == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(autor, HttpStatus.OK);
	    }

    @PostMapping("/autores/update")
    public String updateAutor(@ModelAttribute Autores autor) {
        autoresService.updateAutor(autor);
        return "redirect:/autores";
    }

    @PostMapping("/autores/delete/{id}")
    public String deleteAutor(@PathVariable("id") Integer id) {
        autoresService.deleteAutor(id);
        return "redirect:/autores";
    }
	
	
	
	
	

}
