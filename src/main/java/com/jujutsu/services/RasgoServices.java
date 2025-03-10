package com.jujutsu.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jujutsu.dao.RasgoRepository;
import com.jujutsu.entity.Rasgo;

@Service
public class RasgoServices {

	@Autowired
	private RasgoRepository repo;
	
	//listar RASGOS
	public List<Rasgo> listarRasgos(){
		return repo.findAll();
	}
}
