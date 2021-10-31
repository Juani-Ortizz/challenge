package com.challenge.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.models.entity.Personaje;

@Repository
public interface IPersonajeDAO extends JpaRepository<Personaje, Long> {

}
