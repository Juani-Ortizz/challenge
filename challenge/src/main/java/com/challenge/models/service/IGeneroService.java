package com.challenge.models.service;

import java.util.List;

import com.challenge.models.entity.Genero;



public interface IGeneroService {
	
	public List<Genero> listGeneros();
	public void saveGenero(Genero genero);
	public Genero searchById(Long id);
	public void deleteGenero(Long Id);
}
