package com.sg.biblioteca.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sg.biblioteca.models.Libros;
import com.sg.biblioteca.models.Prestamos;
import com.sg.biblioteca.models.Usuarios;
import com.sg.biblioteca.services.LibrosService;
import com.sg.biblioteca.services.PrestamosService;
import com.sg.biblioteca.services.UsuariosService;

@Controller
public class PrestamosController {

	@Autowired
	private PrestamosService prestamosService;
	@Autowired
	private UsuariosService usuariosService;
	@Autowired
	private LibrosService librosService;
	
	Logger logger = LoggerFactory.getLogger(PrestamosController.class);


	@GetMapping("/prestamos")
	public String getPrestamos(Model model) {
		List<Prestamos> prestamosList = prestamosService.ListPrestamos();
        List<Usuarios> usuariosList = usuariosService.ListUsuarios();
        List<Libros> librosList = librosService.ListLibros();     
		
		Map<Integer, Boolean> devolucionesExistentes = new HashMap<>();
        for (Prestamos prestamo : prestamosList) {
            devolucionesExistentes.put(prestamo.getId(), prestamosService.tieneDevolucion(prestamo.getId()));
        }
        model.addAttribute("devolucionesExistentes", devolucionesExistentes);
        model.addAttribute("libros", librosList);
        model.addAttribute("usuarios", usuariosList);
		model.addAttribute("prestamos", prestamosList);
        
		return "prestamos";
	}
	
	
	

	/*
	 * @PostMapping("/prestamos") public void save(Model model) {
	 * prestamosService.save(model); return "redirect:/prestamos"; }
	 */

	@PostMapping("prestamos")
	public String crearPrestamo(
	        @RequestParam("fechaPrestamo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaPrestamo,
	        @RequestParam(value = "usuario", required = false) Integer usuarioId,
	        @RequestParam(value = "libroId", required = false) Integer libroId,
	        @RequestParam(value = "diasSolicitados", required = false) Integer diasSolicitados,
	        @RequestParam(value = "montoPorDia", required = false) Integer montoPorDia,
	        @RequestParam(value = "empleadoId", required = false) Integer empleadoId,
	        RedirectAttributes redirectAttributes) {
		
		logger.info("fechaPrestamo: {}", fechaPrestamo);
	    logger.info("usuarioId: {}", usuarioId);
	    logger.info("libroId: {}", libroId);
	    logger.info("diasSolicitados: {}", diasSolicitados);
	    logger.info("montoPorDia: {}", montoPorDia);
	    logger.info("empleadoId: {}", empleadoId);

	    // Verifica si algún campo es nulo y añade el mensaje de error adecuado
	    if (usuarioId == null) {
	        redirectAttributes.addFlashAttribute("error", "El campo Usuario es obligatorio.");
	    }
	    if (libroId == null) {
	        redirectAttributes.addFlashAttribute("error", "El campo Libro es obligatorio.");
	    }
	    if (diasSolicitados == null) {
	        redirectAttributes.addFlashAttribute("error", "El campo Días Solicitados es obligatorio.");
	    }
	    if (montoPorDia == null) {
	        redirectAttributes.addFlashAttribute("error", "El campo Monto por Día es obligatorio.");
	    }
	    if (empleadoId == null) {
	        redirectAttributes.addFlashAttribute("error", "El campo Empleado es obligatorio.");
	    }

	    // Si todos los campos son válidos, continúa con la creación del préstamo
	    Prestamos prestamo = prestamosService.createPrestamo(fechaPrestamo, usuarioId, libroId, diasSolicitados,
	            montoPorDia, empleadoId);
	    redirectAttributes.addFlashAttribute("message", "Préstamo guardado con éxito");

	    return "redirect:/prestamos";
	}

}
