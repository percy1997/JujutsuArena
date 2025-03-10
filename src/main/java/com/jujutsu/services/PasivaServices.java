package com.jujutsu.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jujutsu.dao.PasivaRepository;
import com.jujutsu.entity.Pasiva;

@Service
public class PasivaServices {
	
	@Autowired
	private PasivaRepository repo;

	//listar HABILIDADES por codigo de PERSONAJE seleccionado
	public List<Pasiva> listarPasivasPorPersonaje(Integer cod){
		return repo.PasivasPorPersonaje(cod);
	}
}
