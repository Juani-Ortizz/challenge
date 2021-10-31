package com.challenge.models.service;

import com.challenge.models.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
	public Usuario registrar(Usuario u);

}