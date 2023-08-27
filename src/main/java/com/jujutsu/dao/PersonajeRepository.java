package com.jujutsu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujutsu.entity.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {

}
