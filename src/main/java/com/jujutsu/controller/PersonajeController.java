package com.jujutsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jujutsu.entity.Personaje;
import com.jujutsu.services.PersonajeServices;

@Controller
@RequestMapping("/personajes")
public class PersonajeController {
	
	@Autowired
	private PersonajeServices perSer;
	
	@RequestMapping("")
	public String personajes(Model model) {
		model.addAttribute("personajes",perSer.listaPersonajes());
		return "personajes";
	}
	
	//obtener JSON de PERSONAJE
	@RequestMapping("personajePorCodigo")
	@ResponseBody
	public Personaje buscarPersonajePorCodigo(@RequestParam("codigoPersonaje")Integer cod) {		
		return perSer.buscarPersonajePorCodigo(cod);
	}

}
