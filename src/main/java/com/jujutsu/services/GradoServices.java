package com.jujutsu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jujutsu.dao.GradoRepository;
import com.jujutsu.entity.Grado;

@Service
public class GradoServices {

	@Autowired
	private GradoRepository repo;
	
	//listar GRADOS	
	public List<Grado> listarGrados(){
		return repo.findAll();
	}
	
}
