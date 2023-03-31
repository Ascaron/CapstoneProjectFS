package com.epicode.andreacursi.capstoneproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.capstoneproject.entities.ProdottoListaPreferiti;

@Repository
public interface ProdottoListaPreferitiRepository extends JpaRepository<ProdottoListaPreferiti, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM prodotto_lista_preferiti WHERE codice_controllo = :valore"
		)
		List<ProdottoListaPreferiti> findByCodiceControllo(@Param("valore") String valore);
	
}
