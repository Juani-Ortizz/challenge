package com.challenge.models.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.models.dao.IPersonajeDAO;
import com.challenge.models.entity.Personaje;
import com.challenge.models.service.IPersonajeService;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

	private IPersonajeDAO personajeDao;
	
	@Override
	public List<Personaje> listPersonajes() {
		return (List<Personaje>) personajeDao.findAll();
	}

	@Override
	public void savePersonaje(Personaje personaje) {
		personajeDao.save(personaje);
		
	}

	@Override
	public Personaje searchById(Long id) {
		return personajeDao.findById(id).orElse(null);
	}

	@Override
	public void deletePersonaje(Long Id) {
		personajeDao.deleteById(Id);
		
	}


	
}
