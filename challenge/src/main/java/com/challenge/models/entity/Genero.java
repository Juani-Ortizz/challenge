package com.challenge.models.entity;

 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="generos")
public class Genero {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String imagen;
	private String pelicula;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	public Genero(Long id, String nombre, String imagen, String pelicula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.pelicula = pelicula;
	}
	public Genero() {
		super();
	}


	
	


	
}
