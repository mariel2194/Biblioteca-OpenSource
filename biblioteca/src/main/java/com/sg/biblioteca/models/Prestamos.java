package com.sg.biblioteca.models;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
public class Prestamos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@ManyToOne
	private Libros libro;

	@ManyToOne
	private Usuarios usuario;

	@ManyToOne
	@JoinColumn(name = "empleadoId")
	private Empleados empleado;

	@Column(name = "Fecha Prestamo")
	private Date fechaPrestamo;

	@Column(name = "Fecha Devolucion Estimada")

	private Date fechaDevolucionEstimada;

	@Column(name = "Dias Solicitados")
	private int diasSolicitados;

	@Column(name = "Monto Por Dia")
	private double montoPorDia;

	@OneToOne(mappedBy = "prestamo", cascade = CascadeType.ALL)
	private Devoluciones devolucion;

	@PrePersist
	public void prePersist() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaPrestamo);
		calendar.add(Calendar.DAY_OF_MONTH, diasSolicitados);
		this.fechaDevolucionEstimada = calendar.getTime();
	}

	@Column(name = "Activo")
	private boolean activo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Libros getLibro() {
		return libro;
	}

	public void setLibro(Libros libro) {
		this.libro = libro;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucionEstimada() {
		return fechaDevolucionEstimada;
	}

	public void setFechaDevolucionEstimada(Date fechaDevolucionEstimada) {
		this.fechaDevolucionEstimada = fechaDevolucionEstimada;
	}

	public int getDiasSolicitados() {
		return diasSolicitados;
	}

	public void setDiasSolicitados(int diasSolicitados) {
		this.diasSolicitados = diasSolicitados;
	}

	public double getMontoPorDia() {
		return montoPorDia;
	}

	public void setMontoPorDia(double montoPorDia) {
		this.montoPorDia = montoPorDia;
	}

	public Devoluciones getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(Devoluciones devolucion) {
		this.devolucion = devolucion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
