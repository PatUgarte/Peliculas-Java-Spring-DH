
package com.patugarte.practicarestful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.patugarte.practicarestful.model.Pelicula;
import com.patugarte.practicarestful.repository.PeliculaJpaRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PeliculaJpaRepository peliculaRepository;
	
	@GetMapping("")
	public String irAlHome() {
		return "index";
	}
	
	@PostMapping("result")
	public String insertMovie(Model model,Pelicula addedMovie) {
		model.addAttribute("pudoAgregar",peliculaRepository.save(addedMovie));
		return "result";
	}

}
