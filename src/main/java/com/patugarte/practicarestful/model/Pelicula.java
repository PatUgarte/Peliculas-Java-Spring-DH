package com.patugarte.practicarestful.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Double raiting;
	private Integer awards;
	private String category;

	public Pelicula() {
		super();
	}

	public Pelicula(String title, Double raiting, Integer awards, String category) {
		super();
		this.title = title;
		this.raiting = raiting;
		this.awards = awards;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getRaiting() {
		return raiting;
	}

	public void setRaiting(Double raiting) {
		this.raiting = raiting;
	}

	public Integer getAwards() {
		return awards;
	}

	public void setAwards(Integer awards) {
		this.awards = awards;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
