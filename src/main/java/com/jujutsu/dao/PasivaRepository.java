package com.jujutsu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.jujutsu.entity.Pasiva;

public interface PasivaRepository extends JpaRepository<Pasiva, Integer> {

	@Query("select h from Pasiva h where h.personaje.codigoPersonaje = ?1")
	public List<Pasiva> PasivasPorPersonaje(Integer cod);
	
}
