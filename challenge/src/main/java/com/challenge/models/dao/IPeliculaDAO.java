package com.challenge.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.models.entity.Pelicula;

@Repository
public interface IPeliculaDAO extends JpaRepository<Pelicula, Long>{

}
