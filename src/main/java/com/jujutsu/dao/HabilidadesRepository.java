package com.jujutsu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jujutsu.entity.Habilidades;

public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer> {

	@Query("select h from Habilidades h where h.personaje.codigoPersonaje = ?1")
	public List<Habilidades> habilidadesPorPersonaje(Integer cod);
}
