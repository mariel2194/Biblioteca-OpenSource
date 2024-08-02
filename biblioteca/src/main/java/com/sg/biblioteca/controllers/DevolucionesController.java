package com.sg.biblioteca.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sg.biblioteca.models.Devoluciones;
import com.sg.biblioteca.models.Libros;
import com.sg.biblioteca.models.Prestamos;
import com.sg.biblioteca.models.Usuarios;
import com.sg.biblioteca.services.DevolucionesService;
import com.sg.biblioteca.services.LibrosService;
import com.sg.biblioteca.services.PrestamosService;
import com.sg.biblioteca.services.UsuariosService;


@Controller
public class DevolucionesController {
	
	@Autowired
	private DevolucionesService devolucionesService;
	
	@Autowired
	private PrestamosService prestamosService;
	//private LibrosService librosService;

	//private UsuariosService usuariosService;
	Logger logger = LoggerFactory.getLogger(PrestamosController.class);



	@GetMapping("/devoluciones")
	public String getDevoluciones(Model model) {
		List<Devoluciones> devolucionesList = devolucionesService.ListDevoluciones();
        List<Prestamos> prestamosList = prestamosService.ListPrestamos();
        //List<Libros> librosList = librosService.ListLibros();
        //List<Usuarios> usuariosList = usuariosService.ListUsuarios();
        model.addAttribute("prestamos", prestamosList);
		model.addAttribute("devoluciones", devolucionesList);
        //model.addAttribute("usuarios", usuariosList);
        //model.addAttribute("libros", librosList);


		return "devoluciones";
	}
	
	
	
    @PostMapping("devoluciones")
    public String crearDevolucion(
            @RequestParam(value = "prestamoId", required = false) Integer prestamoId,
            @RequestParam("fechaDevolucionActual") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDevolucionActual,
            RedirectAttributes redirectAttributes) {
    	 System.out.println("prestamoId: " + prestamoId);
    	    System.out.println("fechaDevolucionActual: " + fechaDevolucionActual);
    	    logger.info("prestamoId: {}", prestamoId);
    	    logger.info("fechaDevolucionActual: {}", fechaDevolucionActual);

        try {
        	if (prestamoId == null) {
        		
        		redirectAttributes.addFlashAttribute("error", "El campo Prestamo ID es obligatorio.");
            }
        	
        	Devoluciones devolucion = devolucionesService.createDevolucion(prestamoId, fechaDevolucionActual);
            redirectAttributes.addFlashAttribute("message", "Devolución registrada con éxito");

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/devoluciones"; 
    }
}
