package com.jujutsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jujutsu.services.HabilidadesServices;
import com.jujutsu.services.PersonajeServices;

@Controller
@RequestMapping("")
public class UsuarioController {
	
	@Autowired
	private PersonajeServices perSer;
	
	@Autowired
	private HabilidadesServices habSer;
	
	//Pagina de inicio
	@GetMapping("")
	public String index() {
		return "usuario/index";
	}
	
	@GetMapping("manual")
	public String manual() {
		return "usuario/manual";
	}

	@GetMapping("characters")
	public String personajes(Model model) {
		model.addAttribute("personajes",perSer.listaPersonajes());
		return "usuario/characters";
	}
	
	@GetMapping("/chars/{codigo}")
	public String habilidades(@PathVariable("codigo") Integer codigoPersonaje, Model model) {
	    model.addAttribute("characterSelected", perSer.buscarPersonajePorCodigo(codigoPersonaje));		
		model.addAttribute("skills", habSer.listarHabilidadesPorPersonaje(codigoPersonaje));
	    return "usuario/skills";
	}
	

}
