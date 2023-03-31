package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.FilmTv;
import com.epicode.andreacursi.capstoneproject.repositories.FilmTvRepository;

@Service
public class FilmTvService {

	@Autowired
	FilmTvRepository filRepo;
	
	public void inserisci(FilmTv f) {
		filRepo.save(f);
	}
	
	public Optional<FilmTv> ottieniDaId(int id) {
		return filRepo.findById(id);
	}
	
	public Optional<FilmTv> ottieniDaCodiceControllo(String codice) {
		return filRepo.findByCodiceControllo(codice);
	}
	
	public List<FilmTv> ottieniTutti() {
		return filRepo.findAll();
	}
	
	public void elimina(int id) {
		filRepo.deleteById(id);
	}
	
}
