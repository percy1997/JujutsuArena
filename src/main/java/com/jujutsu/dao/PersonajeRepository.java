package com.jujutsu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jujutsu.entity.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {

	@Query("select p from Personaje p where p.habilitarPersonaje = true")
	public List<Personaje> personajeHabilitados();
	
}
