package com.epicode.andreacursi.capstoneproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.capstoneproject.entities.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM musica WHERE codice_controllo = :valore"
		)
		Optional<Musica> findByCodiceControllo(@Param("valore") String valore);
	
}
