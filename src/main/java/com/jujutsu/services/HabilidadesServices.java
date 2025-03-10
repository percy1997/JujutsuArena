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
	
	//listar HABILIDADES por codigo de PERSONAJE seleccionado
	public List<Habilidades> listarHabilidadesPorPersonaje(Integer cod){
		return repo.habilidadesPorPersonaje(cod);
	}
	
	//registrar HABILIDADES
	public void registrarHabilidades(Habilidades h) {
		repo.save(h);
	}
	
	//actualizar HABILIDADES
	public void actualizarHabilidades(Habilidades h) {
		repo.save(h);
	}
	
	//eliminar HABILIDADES
	public void eliminarHabilidades(int cod) {
		repo.deleteById(cod);
	}

}
