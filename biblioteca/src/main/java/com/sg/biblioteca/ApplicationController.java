package com.sg.biblioteca;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.biblioteca.models.Libros;
import com.sg.biblioteca.models.Prestamos;
import com.sg.biblioteca.models.Usuarios;
import com.sg.biblioteca.services.LibrosService;
import com.sg.biblioteca.services.PrestamosService;
import com.sg.biblioteca.services.UsuariosService;

@Controller
public class ApplicationController {
	
	@Autowired
	private PrestamosService prestamosService;
	@Autowired
	private UsuariosService usuariosService;
	@Autowired
	private LibrosService librosService;

	@GetMapping("/index")
	public String goHome(Model model) {
		List<Prestamos> prestamosList = prestamosService.ListPrestamos();
		List<Usuarios> usuariosList = usuariosService.ListUsuarios();
		List<Libros> librosList = librosService.ListLibros();

		Map<Integer, Boolean> devolucionesExistentes = new HashMap<>();
		for (Prestamos prestamo : prestamosList) {
			devolucionesExistentes.put(prestamo.getId(), prestamosService.tieneDevolucion(prestamo.getId()));
		}
		model.addAttribute("devolucionesExistentes", devolucionesExistentes);
		model.addAttribute("libros", librosList);
		
		// Lista de URLs de imágenes
        List<String> imagenes = Arrays.asList(
            "/assets/img/img1.jpg",
            "/assets/img/img2.jpg",
            "/assets/img/img3.jpg",
            "/assets/img/img4.jpg"
        );
        model.addAttribute("imagenes", imagenes);
		model.addAttribute("usuarios", usuariosList);
		model.addAttribute("prestamos", prestamosList);

		return "index";
	}



}
