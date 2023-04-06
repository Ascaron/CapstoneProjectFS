package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository uteRepo;
		
	public void inserisci(Utente u) {
		uteRepo.save(u);
	}
	
	public Optional<Utente> ottieniDaId(int id) {
		return uteRepo.findById(id);
	}
	
	public Optional<Utente> ottieniDaUsername(String valore) {
		return uteRepo.findByUsername(valore);
	}
	
	public List<Utente> ottieniTutti() {
		return uteRepo.findAll();
	}
	
	public void elimina(int id) {
		uteRepo.deleteById(id);
	}
	
}
