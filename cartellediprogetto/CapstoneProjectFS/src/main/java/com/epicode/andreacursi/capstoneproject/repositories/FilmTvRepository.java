package com.epicode.andreacursi.capstoneproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.capstoneproject.entities.FilmTv;

@Repository
public interface FilmTvRepository extends JpaRepository<FilmTv, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM film_tv WHERE codice_controllo = :valore"
		)
		Optional<FilmTv> findByCodiceControllo(@Param("valore") String valore);
	
}
