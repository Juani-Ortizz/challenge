package com.challenge.models.service;

import java.util.List;

import com.challenge.models.entity.Personaje;


public interface IPersonajeService {
	
	public List<Personaje> listPersonajes();
	public void savePersonaje(Personaje personaje);
	public Personaje searchById(Long id);
	public void deletePersonaje(Long Id);
}
