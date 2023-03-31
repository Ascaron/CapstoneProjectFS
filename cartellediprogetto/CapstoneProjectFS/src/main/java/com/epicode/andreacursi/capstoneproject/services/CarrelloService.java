package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.Carrello;
import com.epicode.andreacursi.capstoneproject.repositories.CarrelloRepository;

@Service
public class CarrelloService {

	@Autowired
	CarrelloRepository carRepo;
	
	public void inserisci(Carrello c) {
		carRepo.save(c);
	}
	
	public Optional<Carrello> ottieniDaId(int id) {
		return carRepo.findById(id);
	}
	
	public List<Carrello> ottieniTutti() {
		return carRepo.findAll();
	}
	
	public void elimina(int id) {
		carRepo.deleteById(id);
	}
	
}
