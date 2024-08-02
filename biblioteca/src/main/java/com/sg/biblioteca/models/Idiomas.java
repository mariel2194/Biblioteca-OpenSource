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
public class Idiomas {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Id")
	    private Integer id;
	    

	    @Column(name = "Descripcion", nullable=false)
	    private String descripcion;
	    
	    @Column(name = "Activo")
	    private boolean activo;
	    
	    @OneToMany(mappedBy = "idioma")
	    private List<Autores> autores;

	    @OneToMany(mappedBy = "idioma")
	    private List<Libros> libros;
	    

    public boolean isActivo() {
			return activo;
		}

		public void setActivo(boolean activo) {
			this.activo = activo;
		}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    

   
    }

    







   


   