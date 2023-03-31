package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.FilmTv;
import com.epicode.andreacursi.capstoneproject.services.FilmTvService;

@RestController
@RequestMapping("/filmtv")
@CrossOrigin(origins = "http://localhost:4200")
public class FilmTvController {

	@Autowired
	FilmTvService filSe;
	
	@GetMapping("/tutti")
	public List<FilmTv> ottieniTutti(){
		return filSe.ottieniTutti();
	}
	
	@GetMapping("/filmtvdaid/id={id}")
	public Optional<FilmTv> ottieniDaId(@PathVariable int id) {
		return filSe.ottieniDaId(id);
	}
	
}
