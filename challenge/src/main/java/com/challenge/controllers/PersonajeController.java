package com.challenge.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.challenge.models.entity.Personaje;
import com.challenge.models.service.IPersonajeService;



@Controller
@RequestMapping("/characters")
public class PersonajeController {

	@Autowired
	private IPersonajeService personajeSer;
	
	@GetMapping("/")
	public String listPersonaje(Model model) {
		List<Personaje> listPersonajes = personajeSer.listPersonajes();
		model.addAttribute("titulo", "Personaje!");
		model.addAttribute("peliculas", listPersonajes);
		return "/views/characters/showCharacter"; 
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		
		Personaje personaje = new Personaje();
		
		model.addAttribute("titulo","Form: Nuevo Personaje");
		model.addAttribute("personaje", personaje);

		return "/views/characters/frmCreatePersonaje";
	} 
	 
	@PostMapping("/save")
	public String savePersonaje(@Valid @ModelAttribute Personaje personaje, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			
			model.addAttribute("titulo", "Form: Nuev Personaje");
			model.addAttribute("personaje", personaje);
			System.out.println("Error"); 
			
			return "/views/characters/frmCreatePersonaje";
		}
		
		personajeSer.savePersonaje(personaje);
		System.out.println("Personaje Guardado");
		return "redirect:/characters/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long idPersonaje, Model model) {
		
		Personaje personaje = null;
		
		if (idPersonaje>0) {
			personaje = personajeSer.searchById(idPersonaje);
			if (personaje==null) {
				System.out.println("Id No Existe");
				return "redirect:/characters";
			}
		}else {
			System.out.println("Id error");
			return "redirect:/characters/";
		}
		
		model.addAttribute("titulo", "nuevo Personaje");
		model.addAttribute("personaje", personaje);
		
		return "/views/characters/frmCreatePersonaje";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deletePersonaje(@PathVariable("id") Long idPersonaje) {
		
		Personaje personaje = null;
		
		if (idPersonaje>0) {
			personaje = personajeSer.searchById(idPersonaje);
			if (personaje==null) {
				System.out.println("Id no existe");
				return "redirect:/characters/";
			}
		}else {
			System.out.println("Id error");
			return "redirect:/characters/";
		}
		
		personajeSer.deletePersonaje(idPersonaje);
		System.out.println("Personaje borrado");
		
		return "redirect:/characters/";
		
	}
	
}
