package com.jujutsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jujutsu.services.HabilidadesServices;
import com.jujutsu.services.PasivaServices;
import com.jujutsu.services.PersonajeServices;

@Controller
@RequestMapping("")
public class ContenidoPublico {
	
	@Autowired
	private PersonajeServices perSer;
	@Autowired
	private HabilidadesServices habSer;
	@Autowired
	private PasivaServices pasSer;
	
	//Pagina de inicio
	@GetMapping("")
	public String index() {
		return "contenidoPublico/index";
	}
	
	@GetMapping("manual")
	public String manual() {
		return "contenidoPublico/manual";
	}
	
	@GetMapping("ingame")
	public String ingame() {
		return "contenidoPublico/ingame";
	}

	@GetMapping("characters")
	public String personajes(Model model) {
		model.addAttribute("personajes",perSer.listarPersonajeHabilitados());
		return "contenidoPublico/characters";
	}
	
	@GetMapping("/chars/{codigo}")
	public String habilidades(@PathVariable("codigo") Integer codigoPersonaje, Model model) {
	    model.addAttribute("characterSelected", perSer.buscarPersonajePorCodigo(codigoPersonaje));		
		model.addAttribute("skills", habSer.listarHabilidadesPorPersonaje(codigoPersonaje));
		model.addAttribute("pasivas", pasSer.listarPasivasPorPersonaje(codigoPersonaje));
	    return "contenidoPublico/skills";
	}
}
