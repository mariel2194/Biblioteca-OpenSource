package com.sg.biblioteca.models;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class)
public class Devoluciones {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
	
    
	    @OneToOne
	    @JoinColumn(name = "prestamoId")
	    private Prestamos prestamo;
	

	    @ManyToOne
	    private Usuarios usuario;

	    
	    @Column(name = "Fecha Devolucion Actual")
	    private Date fechaDevolucionActual;
	    
	    
	    @Column(name = "Atraso")
	    private boolean atraso;
	    
	    @Column(name = "Total a Pagar")
	    private double totalPagar;
	    
	    public Usuarios getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuarios usuario) {
			this.usuario = usuario;
		}

		@PrePersist
	    @PreUpdate
	    public void prePersist() {
	        if (fechaDevolucionActual.after(prestamo.getFechaDevolucionEstimada())) {
	            this.atraso = true;
	            long diff = fechaDevolucionActual.getTime() - prestamo.getFechaDevolucionEstimada().getTime();
	            long diasAtraso = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	            this.totalPagar = prestamo.getMontoPorDia() * diasAtraso;
	        } else {
	            this.atraso = false;
	            this.totalPagar = 0;
	        }
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Prestamos getPrestamo() {
			return prestamo;
		}

		public void setPrestamo(Prestamos prestamo) {
			this.prestamo = prestamo;
		}

		public Date getFechaDevolucionActual() {
			return fechaDevolucionActual;
		}

		public void setFechaDevolucionActual(Date fechaDevolucionActual) {
			this.fechaDevolucionActual = fechaDevolucionActual;
		}

		public boolean isAtraso() {
			return atraso;
		}

		public void setAtraso(boolean atraso) {
			this.atraso = atraso;
		}

		public double getTotalPagar() {
			return totalPagar;
		}

		public void setTotalPagar(double totalPagar) {
			this.totalPagar = totalPagar;
		}
   


    
   
    }

    







   


   