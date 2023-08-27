package com.jujutsu.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jujutsu.dao.PersonajeRepository;
import com.jujutsu.entity.Personaje;

@Service
public class PersonajeServices {

	@Autowired
	private PersonajeRepository repo;
	
	//listar
	public List<Personaje> listaPersonajes(){
		return repo.findAll();
	}
	
	//buscar PERSONAJE por id
	public Personaje buscarPersonajePorCodigo(int cod) {
		return repo.findById(cod).orElse(null);
	}
}
