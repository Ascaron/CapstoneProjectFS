package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.Musica;
import com.epicode.andreacursi.capstoneproject.services.MusicaService;

@RestController
@RequestMapping("/musiche")
@CrossOrigin(origins = "http://localhost:4200")
public class MusicaController {

	@Autowired
	MusicaService musSe;
	
	@GetMapping("/tutte")
	public List<Musica> ottieniTutti(){
		return musSe.ottieniTutti();
	}
	
	@GetMapping("/musicadaid/id={id}")
	public Optional<Musica> ottieniDaId(@PathVariable int id) {
		return musSe.ottieniDaId(id);
	}
	
}
