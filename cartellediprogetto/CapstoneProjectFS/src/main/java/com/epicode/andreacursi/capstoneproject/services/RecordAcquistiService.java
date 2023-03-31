package com.epicode.andreacursi.capstoneproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.capstoneproject.entities.RecordAcquisti;
import com.epicode.andreacursi.capstoneproject.repositories.RecordAcquistiRepository;

@Service
public class RecordAcquistiService {
	
	@Autowired
	RecordAcquistiRepository recRepo;

	public void inserisci(RecordAcquisti r) {
		recRepo.save(r);
	}
	
	public Optional<RecordAcquisti> ottieniDaId(int id) {
		return recRepo.findById(id);
	}
	
	public List<RecordAcquisti> ottieniTutti() {
		return recRepo.findAll();
	}
	
	public void elimina(int id) {
		recRepo.deleteById(id);
	}
	
}
