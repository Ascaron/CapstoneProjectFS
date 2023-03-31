package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.ProdottoCarrello;
import com.epicode.andreacursi.capstoneproject.repositories.ProdottoCarrelloRepository;

@Service
public class ProdottoCarrelloService {

	@Autowired
	ProdottoCarrelloRepository proRepo;
	
	public void inserisci(ProdottoCarrello p) {
		proRepo.save(p);
	}
	
	public Optional<ProdottoCarrello> ottieniDaId(int id) {
		return proRepo.findById(id);
	}
	
	public List<ProdottoCarrello> ottieniDaCodiceControllo(String codice) {
		return proRepo.findByCodiceControllo(codice);
	}
	
	public List<ProdottoCarrello> ottieniTutti() {
		return proRepo.findAll();
	}
	
	public void elimina(int id) {
		proRepo.deleteById(id);
	}
	
}
