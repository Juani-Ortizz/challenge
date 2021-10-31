package com.challenge.models.service;

import java.util.List;

import com.challenge.models.entity.Pelicula;



public interface IPeliculaService {

	public List<Pelicula> listPeliculas();
	public void savePelicula(Pelicula pelicula);
	public Pelicula searchById(Long id);
	public void deletePelicula(Long Id);
}
