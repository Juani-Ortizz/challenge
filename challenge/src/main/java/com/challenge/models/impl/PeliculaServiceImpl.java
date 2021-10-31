package com.challenge.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.models.dao.IPeliculaDAO;
import com.challenge.models.entity.Pelicula;
import com.challenge.models.service.IPeliculaService;

@Service
public class PeliculaServiceImpl implements IPeliculaService{

	@Autowired
	private IPeliculaDAO peliculaDao;
	
	@Override
	public List<Pelicula> listPeliculas() {
		return (List<Pelicula>) peliculaDao.findAll();
	}

	@Override
	public void savePelicula(Pelicula pelicula) {
		peliculaDao.save(pelicula);
		
	}

	@Override
	public Pelicula searchById(Long id) {
		return peliculaDao.findById(id).orElse(null);
	}

	@Override
	public void deletePelicula(Long Id) {
		peliculaDao.deleteById(Id);
		
	}

}
