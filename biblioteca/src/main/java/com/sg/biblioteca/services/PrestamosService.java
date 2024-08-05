package com.sg.biblioteca.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.Prestamos;
import com.sg.biblioteca.models.Libros;
import com.sg.biblioteca.repositories.DevolucionesRepository;
import com.sg.biblioteca.repositories.EmpleadosRepository;
import com.sg.biblioteca.repositories.LibrosRepository;
import com.sg.biblioteca.repositories.PrestamosRepository;
import com.sg.biblioteca.repositories.UsuariosRepository;

@Service
public class PrestamosService {

	@Autowired
	private PrestamosRepository prestamosRepository;

	@Autowired
	private UsuariosRepository usuariosRepository;

	@Autowired
	private LibrosRepository librosRepository;

	@Autowired
	private DevolucionesRepository devolucionesRepository;
	
	@Autowired
	private EmpleadosRepository empleadosRepository;

	// Return list of prestamos
	public List<Prestamos> ListPrestamos() {
		return prestamosRepository.findAll();
	}
	
	public boolean tieneDevolucion(Integer prestamoId) {
        return devolucionesRepository.existsByPrestamoId(prestamoId);
    }

	public Prestamos createPrestamo(Date fechaPrestamo, Integer usuarioId, Integer libroId, Integer diasSolicitados,
	        Integer montoPorDia, Integer empleadoId) {

	    Prestamos prestamo = new Prestamos();
	    prestamo.setFechaPrestamo(fechaPrestamo);
	    prestamo.setUsuario(usuariosRepository.findById(usuarioId).orElse(null));
	    prestamo.setLibro(librosRepository.findById(libroId).orElse(null));
	    prestamo.setDiasSolicitados(diasSolicitados);
	    prestamo.setMontoPorDia(montoPorDia);
	    prestamo.setEmpleado(empleadosRepository.findById(empleadoId).orElse(null));

	    // Reduce la cantidad del libro
	    Libros libro = prestamo.getLibro();
	    if (libro != null) {
	        libro.setCantidad(libro.getCantidad() - 1);
	        librosRepository.save(libro);
	    }

	    return prestamosRepository.save(prestamo);
	}


	private Date calcularFechaDevolucionEstimada(Date fechaPrestamo, int diasSolicitados) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaPrestamo);
		calendar.add(Calendar.DAY_OF_YEAR, diasSolicitados);
		return calendar.getTime();
	}

}
