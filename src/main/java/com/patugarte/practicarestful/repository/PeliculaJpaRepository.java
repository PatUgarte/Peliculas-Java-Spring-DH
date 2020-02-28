package com.patugarte.practicarestful.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.patugarte.practicarestful.model.Pelicula;

public interface PeliculaJpaRepository extends JpaRepository<Pelicula, Integer> {

//	a. Traer las películas que tengan un rating mayor al dado.
	List<Pelicula> findByRaitingGreaterThan(Double raiting);
// JPQL
	@Query("select p from Pelicula p where p.raiting > :raiting")
	List<Pelicula> jpqlFindByRaitingGreaterThan(@Param("raiting") Double raiting);

//	b. Listar las películas que tengan un rating menor al dado.
	List<Pelicula> findByRaitingLessThan(Double raiting);
// JPQL
	@Query("select p from Pelicula p where p.raiting < :raiting")
	List<Pelicula> jpqlFindByRaitingLessThan(@Param("raiting") Double raiting);

//	c. Mostrar las películas que tengan un rating menor e igual al rating dado.
	List<Pelicula> findByRaitingLessThanEqual(Double raiting);
// JPQL
	@Query("select p from Pelicula p where p.raiting <= :raiting")
	List<Pelicula> jpqlFindByRaitingLessThanEqual(@Param("raiting") Double raiting);

//	d. Listar la película que coincida un titulo en particular.
	List<Pelicula> findByTitle(String title);
// JPQL
	@Query("select p from Pelicula p where p.title is :title")
	List<Pelicula> jpqlFindByTitle(@Param("title") String title);

//	e. Listar las películas que no sean de una categoría en particular.
	List<Pelicula> findByCategory(String category);
// JPQL
	@Query("select p from Pelicula p where p.category is :category")
	List<Pelicula> jpqlFindByCategory(@Param("category") String category);

//	f. Listar las películas cuyo titulo comienzan con una letra en particular.
	List<Pelicula> findByTitleStartingWith(String title);
// JPQL
	@Query("select p from Pelicula p where p.title like :title%")
	List<Pelicula> jpqlFindByTitleStartingWith(@Param("title") String title);

//	g. Mostrar las películas por categoría ordenadas descendentemente.
	List<Pelicula> findAllByOrderByCategoryDesc();
// JPQL
	@Query("select p from Pelicula p")
	List<Pelicula> jpqlFindAllByOrderByCategoryDesc(Sort sort);

}
