package com.challenge.models.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.models.dao.IGeneroDAO;
import com.challenge.models.entity.Genero;
import com.challenge.models.service.IGeneroService;

public class GeneroServiceImpl implements IGeneroService{

	@Autowired
	private IGeneroDAO generoDao;
	
	@Override
	public List<Genero> listGeneros() {
		return (List<Genero>) generoDao.findAll();
	}

	@Override
	public void saveGenero(Genero genero) {
		generoDao.save(genero);
	}

	@Override
	public Genero searchById(Long id) {
		return generoDao.findById(id).orElse(null);
	}

	@Override
	public void deleteGenero(Long Id) {
		generoDao.deleteById(Id);
		
	}

}
