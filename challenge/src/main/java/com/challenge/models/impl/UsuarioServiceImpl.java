package com.challenge.models.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.challenge.models.dao.IUsuarioDAO;
import com.challenge.models.entity.Usuario;
import com.challenge.models.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Override
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override 
	public Usuario registrar(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return usuarioDao.save(u);
	}

}
