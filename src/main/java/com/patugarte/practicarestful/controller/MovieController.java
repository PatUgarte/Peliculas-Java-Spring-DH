package com.patugarte.practicarestful.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patugarte.practicarestful.model.Pelicula;
import com.patugarte.practicarestful.repository.PeliculaJpaRepository;

@Controller
@RequestMapping("movies")
public class MovieController {

	@Autowired
	private PeliculaJpaRepository peliculaRepository;

	@GetMapping("")
	public String goToHomepage(Model model) {
		List<Pelicula> movieList = peliculaRepository.findAll();
		model.addAttribute("movieList", movieList);
		return "movie/index";
	}

	@GetMapping("add")
	public String goToMovieAdder() {
		return "movie/add";
	}

	@GetMapping("get/{id}")
	public String getMovieById(@PathVariable("id") Integer id, Model model) {
		Pelicula peliculaSeleccionada = peliculaRepository.getOne(id);
		model.addAttribute("peli", peliculaSeleccionada);
		return "movie/detail";
	}

	@GetMapping("search")
	public String searchMovie() {
		return "movie/search";
	}

	@PostMapping("search-result")
	public String searchResult(
			@RequestParam("filtro") String filtro,
			@Nullable @RequestParam("raitingBuscado") Double raitingBuscado,
			@Nullable @RequestParam("tituloBuscado") String tituloBuscado,
			@Nullable @RequestParam("categoriaBuscada") String categoriaBuscada,
			Model model) 
	{
		List<Pelicula> listaDePeliculas = new ArrayList<>();
		switch (filtro) {
		case "raitingGreaterThan":
			listaDePeliculas = peliculaRepository.jpqlFindByRaitingGreaterThan(raitingBuscado);
			break;
		case "raitingLessThan":
			listaDePeliculas = peliculaRepository.jpqlFindByRaitingLessThan(raitingBuscado);
			break;
		case "raitingLessThanEqual":
			listaDePeliculas = peliculaRepository.jpqlFindByRaitingLessThanEqual(raitingBuscado);
			break;
		case "byTitle":
			listaDePeliculas = peliculaRepository.jpqlFindByTitle(tituloBuscado);
			break;
		case "byCategory":
			listaDePeliculas = peliculaRepository.jpqlFindByCategory(categoriaBuscada);
			break;
		case "byTitleStartingWith":
			listaDePeliculas = peliculaRepository.jpqlFindByTitleStartingWith(tituloBuscado);
			break;
		case "orderedByCategoryDesc":
			listaDePeliculas = peliculaRepository.jpqlFindAllByOrderByCategoryDesc(Sort.by(Direction.DESC, "category"));
			break;
		}

		model.addAttribute("listaDePeliculas", listaDePeliculas);
		model.addAttribute("filtro", filtro);
		model.addAttribute("raitingBuscado", raitingBuscado);
		model.addAttribute("tituloBuscado", tituloBuscado);
		model.addAttribute("categoriaBuscada", categoriaBuscada);

		return "movie/search-result";
	}
}
