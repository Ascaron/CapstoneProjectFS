package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.Videogioco;
import com.epicode.andreacursi.capstoneproject.repositories.VideogiocoRepository;

@Service
public class VideogiocoService {

	@Autowired
	VideogiocoRepository vidRepo;
	
	public void inserisci(Videogioco v) {
		vidRepo.save(v);
	}
	
	public Optional<Videogioco> ottieniDaId(int id) {
		return vidRepo.findById(id);
	}
	
	public Optional<Videogioco> ottieniDaCodiceControllo(String codice) {
		return vidRepo.findByCodiceControllo(codice);
	}
	
	public List<Videogioco> ottieniTutti() {
		return vidRepo.findAll();
	}
	
	public void elimina(int id) {
		vidRepo.deleteById(id);
	}
	
}
