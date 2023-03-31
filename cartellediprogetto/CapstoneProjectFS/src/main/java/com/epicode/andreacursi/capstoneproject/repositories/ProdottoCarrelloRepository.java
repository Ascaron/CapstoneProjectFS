package com.epicode.andreacursi.capstoneproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.capstoneproject.entities.ProdottoCarrello;

@Repository
public interface ProdottoCarrelloRepository extends JpaRepository<ProdottoCarrello, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM prodotto_carrello WHERE codice_controllo = :valore"
		)
		List<ProdottoCarrello> findByCodiceControllo(@Param("valore") String valore);
	
}
