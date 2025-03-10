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
	
	//registrar PERSONAJE
	public void registrarPersonaje(Personaje p) {
		repo.save(p);
	}
	
	//actualizar PERSONAJE
	public void actualizarPersonaje(Personaje p) {
		repo.save(p);	
	}
	
	//eliminar PERSONAJE
	public void eliminarPersonaje(int cod) {
		repo.deleteById(cod);
	}
	
	//listar
	public List<Personaje> listaPersonajes(){
		return repo.findAll();
	}
	
	//buscar PERSONAJE por id
	public Personaje buscarPersonajePorCodigo(int cod) {
		return repo.findById(cod).orElse(null);
	}
	
	//listar PERSONAJES habilitados para estar en vivo
	public List<Personaje> listarPersonajeHabilitados(){
		return repo.personajeHabilitados();
	}
}
