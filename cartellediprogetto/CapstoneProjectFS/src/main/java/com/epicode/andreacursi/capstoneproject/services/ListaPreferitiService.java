package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.ListaPreferiti;
import com.epicode.andreacursi.capstoneproject.repositories.ListaPreferitiRepository;

@Service
public class ListaPreferitiService {

	@Autowired
	ListaPreferitiRepository lisRepo;
	
	public void inserisci(ListaPreferiti l) {
		lisRepo.save(l);
	}
	
	public Optional<ListaPreferiti> ottieniDaId(int id) {
		return lisRepo.findById(id);
	}
	
	public List<ListaPreferiti> ottieniTutti() {
		return lisRepo.findAll();
	}
	
	public void elimina(int id) {
		lisRepo.deleteById(id);
	}
	
}
