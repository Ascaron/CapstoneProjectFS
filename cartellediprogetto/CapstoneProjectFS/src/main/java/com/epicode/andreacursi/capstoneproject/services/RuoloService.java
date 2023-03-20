package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.Ruolo;
import com.epicode.andreacursi.capstoneproject.repositories.RuoloRepository;

@Service
public class RuoloService {

	@Autowired
	RuoloRepository ruoRepo;
	
	public void inserisci(Ruolo r) {
		ruoRepo.save(r);
	}
	
	public Optional<Ruolo> ottieniDaId(int id) {
		return ruoRepo.findById(id);
	}
	
	public List<Ruolo> ottieniTutti() {
		return ruoRepo.findAll();
	}
	
	public void elimina(int id) {
		ruoRepo.deleteById(id);
	}
	
}
