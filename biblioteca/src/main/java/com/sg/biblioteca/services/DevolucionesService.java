package com.sg.biblioteca.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Devoluciones;
import com.sg.biblioteca.models.Libros;
import com.sg.biblioteca.models.Prestamos;
import com.sg.biblioteca.repositories.DevolucionesRepository;
import com.sg.biblioteca.repositories.LibrosRepository;
import com.sg.biblioteca.repositories.PrestamosRepository;

@Service
public class DevolucionesService {

	@Autowired
	private DevolucionesRepository devolucionesRepository;

	@Autowired
	private PrestamosRepository prestamosRepository;

	@Autowired
	private LibrosRepository librosRepository;

	// Return list of devoluciones
	public List<Devoluciones> ListDevoluciones() {
		return devolucionesRepository.findAll();
	}

	public Devoluciones createDevolucion(Integer prestamoId, Date fechaDevolucionActual) {
		Prestamos prestamo = prestamosRepository.findById(prestamoId).orElse(null);
		if (prestamo == null) {
			throw new IllegalArgumentException("Préstamo no encontrado");
		}

		Devoluciones devolucion = new Devoluciones();
		devolucion.setPrestamo(prestamo);
		devolucion.setFechaDevolucionActual(fechaDevolucionActual);
		devolucion.setUsuario(prestamo.getUsuario());

		// Calculate totalPagar and update atrasos
		devolucion.prePersist();

		Libros libro = prestamo.getLibro();
		if (libro != null) {
			libro.setCantidad(libro.getCantidad() + 1);
			librosRepository.save(libro);
		}

		return devolucionesRepository.save(devolucion);
	}

}
