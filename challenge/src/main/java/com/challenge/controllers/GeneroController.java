package com.challenge.controllers;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.challenge.models.entity.Genero;
import com.challenge.models.service.IGeneroService;

@Controller
@RequestMapping("/generos")
public class GeneroController {

	
	private IGeneroService generoSer;
	
	@GetMapping("/")
	public String listGenero(Model model) {
		List<Genero> listGeneros = generoSer.listGeneros();
		model.addAttribute("titulo", "Genero!");
		model.addAttribute("generos", listGeneros);
		return "/views/generos/showGenero"; 
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		
		Genero genero = new Genero();
		
		model.addAttribute("titulo","Form: Nuevo Genero");
		model.addAttribute("genero", genero);

		return "/views/generos/frmCreateGenero";
	} 
	 
	@PostMapping("/save")
	public String saveGenero(@Valid @ModelAttribute Genero genero, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			
			model.addAttribute("titulo", "Form: Nuevo Genero");
			model.addAttribute("genero", genero);
			System.out.println("Error"); 
			
			return "/views/generos/frmCreateGenero";
		}
		
		generoSer.saveGenero(genero);
		System.out.println("Genero Guardado");
		return "redirect:/generos/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long idGenero, Model model) {
		
		Genero genero = null;
		
		if (idGenero>0) {
			genero = generoSer.searchById(idGenero);
			if (genero==null) {
				System.out.println("Id No Existe");
				return "redirect:/generos";
			}
		}else {
			System.out.println("Id error");
			return "redirect:/generos/";
		}
		
		model.addAttribute("titulo", "nuevo Genero");
		model.addAttribute("genero", genero);
		
		return "/views/generos/frmCreateGenero";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteGenero(@PathVariable("id") Long idGenero) {
		
		Genero genero = null;
		
		if (idGenero>0) {
			genero = generoSer.searchById(idGenero);
			if (genero==null) {
				System.out.println("Id no existe");
				return "redirect:/generos/";
			}
		}else {
			System.out.println("Id error");
			return "redirect:/generos/";
		}
		
		generoSer.deleteGenero(idGenero);
		System.out.println("Genero borrado");
		
		return "redirect:/generos/";
		
	}
	
}