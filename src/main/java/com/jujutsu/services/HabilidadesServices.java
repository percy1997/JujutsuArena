package com.jujutsu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jujutsu.dao.HabilidadesRepository;
import com.jujutsu.entity.Habilidades;

@Service
public class HabilidadesServices {
	
	@Autowired
	private HabilidadesRepository repo;
	
	public List<Habilidades> listarHabilidadesPorPersonaje(Integer cod){
		return repo.habilidadesPorPersonaje(cod);
	}

}
