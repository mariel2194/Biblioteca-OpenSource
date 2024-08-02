package com.sg.biblioteca.models;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class)
public class Libros {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Id")
	    private Integer id;

	    @Column(name = "Descripcion", nullable=false)
	    private String descripcion;
	    
	    @Column(name = "Anio de Publicacion")
	    private String anioPublicacion;

	    @ManyToOne
	    @JoinColumn(name = "autorId")
	    private Autores autor;

	    @ManyToOne
	    @JoinColumn(name = "editoraId")
	    private Editoras editora;
	        
	    @Column(name = "ISBN")
	    private String ISBN;
	    
	    @Column(name = "Edicion")
	    private String edicion;
	    
	    @Column(name = "Cantidad")
	    private int cantidad;
	    
	    @ManyToOne
	    private Idiomas idioma;
	    
	    @Column(name = "Signatura Tipografica")
	    private String signaturaTipografica;

	    @ManyToOne
	    private Ciencias ciencia;
	    
	    @Column(name = "Activo")
	    private boolean activo;
	    	   

       public boolean isActivo() {
			return activo;
		}

		public void setActivo(boolean activo) {
			this.activo = activo;
		}

	public String getAnioPublicacion() {
			return anioPublicacion;
		}

		public void setAnioPublicacion(String anoPublicacion) {
			this.anioPublicacion = anoPublicacion;
		}

		public String getEdicion() {
			return edicion;
		}

		public void setEdicion(String edicion) {
			this.edicion = edicion;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public Idiomas getIdioma() {
			return idioma;
		}

		public void setIdioma(Idiomas idioma) {
			this.idioma = idioma;
		}

		public Autores getAutor() {
			return autor;
		}

		public void setAutor(Autores autor) {
			this.autor = autor;
		}

		public Editoras getEditora() {
			return editora;
		}

		public void setEditora(Editoras editora) {
			this.editora = editora;
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

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getSignaturaTipografica() {
		return signaturaTipografica;
	}

	public void setSignaturaTipografica(String signaturaTipografica) {
		this.signaturaTipografica = signaturaTipografica;
	}

	public Ciencias getCiencia() {
		return ciencia;
	}

	public void setCiencia(Ciencias ciencias) {
		this.ciencia = ciencias;
	}

    

   
    }

    







   


   