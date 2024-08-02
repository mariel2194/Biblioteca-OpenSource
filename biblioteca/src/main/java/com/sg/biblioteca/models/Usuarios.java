package com.sg.biblioteca.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class)
public class Usuarios {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
	
    @Column(name = "Nombre", nullable=false)
    private String nombre;
    
    @Column(name = "Cedula")
    private String cedula;  
    
    @Column(name = "N.o Carnet")
    private String noCarnet;
    
    @Column(name = "Tipo Persona")
    private String tipoPersona;    
    
    
    @Column(name = "Activo")    
    private boolean activo;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Prestamos> prestamos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Devoluciones> devoluciones;
    
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

      public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNoCarnet() {
		return noCarnet;
	}

	public void setNoCarnet(String noCarnet) {
		this.noCarnet = noCarnet;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	

   
    }

    







   


   