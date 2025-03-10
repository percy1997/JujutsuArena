package com.jujutsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jujutsu.entity.Grado;
import com.jujutsu.entity.Personaje;
import com.jujutsu.entity.Rasgo;
import com.jujutsu.services.GradoServices;
import com.jujutsu.services.HabilidadesServices;
import com.jujutsu.services.PersonajeServices;
import com.jujutsu.services.RasgoServices;

@Controller
@RequestMapping("dev")
public class DesarrolloController {

	@Autowired
	private PersonajeServices perSer;
	@Autowired
	private HabilidadesServices habSer;
	@Autowired
	private RasgoServices rasSer;
	@Autowired
	private GradoServices graSer;

	@GetMapping("index")
	public String index(Model model) {
		model.addAttribute("personajes",perSer.listarPersonajeHabilitados());
		return "desarrollo/index";
	}
	
	@GetMapping("new")
	public String nuevo(Model model) {
		model.addAttribute("grados", graSer.listarGrados());
		model.addAttribute("rasgos", rasSer.listarRasgos());
		return "desarrollo/newCharacter";
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<String> registrar(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("imagen") String imagen,
			@RequestParam("rasgo") int rasgo,
			@RequestParam("grado") int grado) {

		try {
			Personaje obj = new Personaje();
			obj.setCodigoPersonaje(0);
			obj.setNombrePersonaje(nombre);
			obj.setDescripcionPersonaje(descripcion);
			obj.setImagenPersonaje(imagen);
			obj.setHabilitarPersonaje(false);
			
			Grado gradoObj = new Grado();
			gradoObj.setCodigoGrado(grado);
			obj.setGrado(gradoObj);
			
			Rasgo rasgoObj = new Rasgo();
			rasgoObj.setCodigoRasgo(rasgo);
			obj.setRasgo(rasgoObj);
			perSer.registrarPersonaje(obj);
            return ResponseEntity.ok("El registro se realizó correctamente");

		} catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error al registrar el personaje");
		}
	}
	
	@GetMapping("characters")
	public String personajes(Model model) {
		return "desarrollo/characters";
	}
	
	@GetMapping("/chars/{codigo}")
	public String habilidades(@PathVariable("codigo") Integer codigoPersonaje, Model model) {
	    model.addAttribute("characterSelected", perSer.buscarPersonajePorCodigo(codigoPersonaje));		
		model.addAttribute("skills", habSer.listarHabilidadesPorPersonaje(codigoPersonaje));
	    return "desarrollo/skills";
	}
}
