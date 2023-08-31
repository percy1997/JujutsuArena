package com.jujutsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jujutsu.entity.Personaje;
import com.jujutsu.services.HabilidadesServices;
import com.jujutsu.services.PersonajeServices;

@Controller
@RequestMapping("/personajes")
public class PersonajeController {
	
	@Autowired
	private PersonajeServices perSer;
	
	@Autowired
	private HabilidadesServices habSer;
	
	@RequestMapping("")
	public String personajes(Model model) {
		model.addAttribute("personajes",perSer.listaPersonajes());
		return "personajes";
	}
	
	@RequestMapping("/habilidades")
	public String habilidades(@RequestParam("codigo-personaje")Integer codigo,Model model) {
		model.addAttribute("personajeSeleccionado",perSer.buscarPersonajePorCodigo(codigo));
		model.addAttribute("habilidades", habSer.listarHabilidadesPorPersonaje(codigo));
		return "habilidades_personaje";
	}
	

}
