package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.Musica;
import com.epicode.andreacursi.capstoneproject.repositories.MusicaRepository;

@Service
public class MusicaService {

	@Autowired
	MusicaRepository musRepo;
	
	public void inserisci(Musica m) {
		musRepo.save(m);
	}
	
	public Optional<Musica> ottieniDaId(int id) {
		return musRepo.findById(id);
	}
	
	public Optional<Musica> ottieniDaCodiceControllo(String codice) {
		return musRepo.findByCodiceControllo(codice);
	}
	
	public List<Musica> ottieniTutti() {
		return musRepo.findAll();
	}
	
	public void elimina(int id) {
		musRepo.deleteById(id);
	}
	
}
