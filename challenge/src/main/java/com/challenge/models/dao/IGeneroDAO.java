package com.challenge.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.models.entity.Genero;

@Repository
public interface IGeneroDAO extends JpaRepository<Genero, Long> {

}
