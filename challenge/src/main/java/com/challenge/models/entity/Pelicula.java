package com.challenge.models.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="peliculas")
public class Pelicula {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String imagen;
	private String titulo;
	private Date fecha;
	private byte calificacion;
	private String personaje;
	private String genero;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public byte getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(byte calificacion) {
		this.calificacion = calificacion;
	}
	public String getPersonaje() {
		return personaje;
	}
	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Pelicula(Long id, String imagen, String titulo, Date fecha, byte calificacion, String personaje,
			String genero) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.titulo = titulo;
		this.fecha = fecha;
		this.calificacion = calificacion;
		this.personaje = personaje;
		this.genero = genero;
	}
	public Pelicula() {
		super();
	}
	
	
	
	
}
