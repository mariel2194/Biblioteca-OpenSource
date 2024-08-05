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

import com.sg.biblioteca.models.Libros;
import com.sg.biblioteca.models.Usuarios;
import com.sg.biblioteca.models.Empleados;
import com.sg.biblioteca.models.Ciencias;
import com.sg.biblioteca.models.Idiomas;
import com.sg.biblioteca.models.Editoras;
import com.sg.biblioteca.models.Autores;
import com.sg.biblioteca.services.AutoresService;
import com.sg.biblioteca.services.CienciasService;
import com.sg.biblioteca.services.EditorasService;
import com.sg.biblioteca.services.EmpleadosService;
import com.sg.biblioteca.services.IdiomasService;
import com.sg.biblioteca.services.LibrosService;
import com.sg.biblioteca.services.UsuariosService;

@Controller
public class LibrosController {

	@Autowired
	private LibrosService librosService;
	@Autowired
	private AutoresService autoresService;
	@Autowired
	private IdiomasService idiomasService;
	@Autowired
	private EditorasService editorasService;
	@Autowired
	private UsuariosService usuariosService;
	@Autowired
	private EmpleadosService empleadosService;
	
	@Autowired
	private CienciasService cienciasService;

	private static final Logger logger = LoggerFactory.getLogger(LibrosController.class);

	@GetMapping("/libros")
	public String getLibros(Model model) {
		List<Libros> librosList = librosService.ListLibros();
		List<Usuarios> usuariosList = usuariosService.ListUsuarios();
		List<Autores> autoresList = autoresService.ListAutores();
		List<Editoras> editorasList = editorasService.ListEditoras();
		List<Idiomas> idiomasList = idiomasService.ListIdiomas();
        List<Ciencias> cienciasList = cienciasService.ListCiencias();
		List<Empleados> empleadosList = empleadosService.ListEmpleados();
		model.addAttribute("empleados", empleadosList);
        model.addAttribute("usuarios", usuariosList);
        model.addAttribute("ciencias", cienciasList);
		model.addAttribute("libros", librosList);
		model.addAttribute("autores", autoresList);
		model.addAttribute("editoras", editorasList);
		model.addAttribute("idiomas", idiomasList);
		return "libros";
	}

    @PostMapping("/libros/addnew")
    public String addNew(Libros libro, Model model) {
        try {
            librosService.saveNew(libro);
            return "redirect:/libros";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al guardar el libro: " + e.getMessage());
            List<Autores> autoresList = autoresService.ListAutores();
            List<Ciencias> cienciasList = cienciasService.ListCiencias();
            List<Editoras> editorasList = editorasService.ListEditoras();
            List<Idiomas> idiomasList = idiomasService.ListIdiomas();
            model.addAttribute("ciencias", cienciasList);
            model.addAttribute("autores", autoresList);
            model.addAttribute("editoras", editorasList);
            model.addAttribute("idiomas", idiomasList);
            model.addAttribute("libro", libro);
            return "crearLibro";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", "Error en el sistema: " + e.getMessage());
        return "error";
    }

    @GetMapping("/libros/edit/{id}")
    @ResponseBody
    public ResponseEntity<Libros> getEditLibrosForm(@PathVariable("id") Integer id) {
        Libros libro = librosService.getLibroById(id);
        if (libro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }

    @PostMapping("/libros/update")
    public String updateLibro(@ModelAttribute Libros libro) {
        librosService.updateLibro(libro);
        return "redirect:/libros";
    }

    @PostMapping("/libros/delete/{id}")
    public String deleteLibro(@PathVariable("id") Integer id) {
        librosService.deleteLibro(id);
        return "redirect:/libros";
    }
}
