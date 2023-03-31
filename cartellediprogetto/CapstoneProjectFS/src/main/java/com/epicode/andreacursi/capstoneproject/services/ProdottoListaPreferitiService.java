package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.ProdottoListaPreferiti;
import com.epicode.andreacursi.capstoneproject.repositories.ProdottoListaPreferitiRepository;

@Service
public class ProdottoListaPreferitiService {

	@Autowired
	ProdottoListaPreferitiRepository proRepo;
	
	public void inserisci(ProdottoListaPreferiti p) {
		proRepo.save(p);
	}
	
	public Optional<ProdottoListaPreferiti> ottieniDaId(int id) {
		return proRepo.findById(id);
	}
	
	public List<ProdottoListaPreferiti> ottieniDaCodiceControllo(String codice) {
		return proRepo.findByCodiceControllo(codice);
	}
	
	public List<ProdottoListaPreferiti> ottieniTutti() {
		return proRepo.findAll();
	}
	
	public void elimina(int id) {
		proRepo.deleteById(id);
	}
	
}
