package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.Videogioco;
import com.epicode.andreacursi.capstoneproject.services.VideogiocoService;

@RestController
@RequestMapping("/videogiochi")
public class VideogiocoController {

	@Autowired
	VideogiocoService vidSe;
	
	@GetMapping("/tutti")
	public List<Videogioco> ottieniTutti(){
		return vidSe.ottieniTutti();
	}
	
}
