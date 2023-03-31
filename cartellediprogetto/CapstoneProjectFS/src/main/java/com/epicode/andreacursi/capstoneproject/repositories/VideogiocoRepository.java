package com.epicode.andreacursi.capstoneproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.capstoneproject.entities.Videogioco;

@Repository
public interface VideogiocoRepository extends JpaRepository<Videogioco, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM videogioco WHERE codice_controllo = :valore"
		)
		Optional<Videogioco> findByCodiceControllo(@Param("valore") String valore);
	
}
