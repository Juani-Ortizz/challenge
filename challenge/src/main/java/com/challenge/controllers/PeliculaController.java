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

import com.challenge.models.entity.Pelicula;
import com.challenge.models.service.IPeliculaService;



@Controller
@RequestMapping("/movies")
public class PeliculaController {

	@Autowired
	private IPeliculaService peliculaSer;
	
	@GetMapping("/")
	public String listPelicula(Model model) {
		List<Pelicula> listPeliculas = peliculaSer.listPeliculas();
		model.addAttribute("titulo", "Pelicula!");
		model.addAttribute("peliculas", listPeliculas);
		return "/views/movies/showPelicula"; 
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		
		Pelicula pelicula = new Pelicula();
		
		model.addAttribute("titulo","Form: Nueva Pelicula");
		model.addAttribute("pelicula", pelicula);

		return "/views/movies/frmCreatePelicula";
	} 
	 
	@PostMapping("/save")
	public String savePelicula(@Valid @ModelAttribute Pelicula pelicula, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			
			model.addAttribute("titulo", "Form: Nueva Pelicula");
			model.addAttribute("pelicula", pelicula);
			System.out.println("Error"); 
			
			return "/views/movies/frmCreatePelicula";
		}
		
		peliculaSer.savePelicula(pelicula);
		System.out.println("Pelicula Guardada");
		return "redirect:/movies/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long idPelicula, Model model) {
		
		Pelicula pelicula = null;
		
		if (idPelicula>0) {
			pelicula = peliculaSer.searchById(idPelicula);
			if (pelicula==null) {
				System.out.println("Id No Existe");
				return "redirect:/movies";
			}
		}else {
			System.out.println("Id error");
			return "redirect:/movies/";
		}
		
		model.addAttribute("titulo", "nueva Pelicula");
		model.addAttribute("pelicula", pelicula);
		
		return "/views/movies/frmCreatePelicula";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deletePelicula(@PathVariable("id") Long idPelicula) {
		
		Pelicula pelicula = null;
		
		if (idPelicula>0) {
			pelicula = peliculaSer.searchById(idPelicula);
			if (pelicula==null) {
				System.out.println("Id no existe");
				return "redirect:/movies/";
			}
		}else {
			System.out.println("Id error");
			return "redirect:/movies/";
		}
		
		peliculaSer.deletePelicula(idPelicula);
		System.out.println("Pelicula borrada");
		
		return "redirect:/movies/";
		
	}
	
}
