package com.epicode.andreacursi.capstoneproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.capstoneproject.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM utente WHERE username = :valore"
		)
		Optional<Utente> findByUsername(@Param("valore") String valore);
	
}
