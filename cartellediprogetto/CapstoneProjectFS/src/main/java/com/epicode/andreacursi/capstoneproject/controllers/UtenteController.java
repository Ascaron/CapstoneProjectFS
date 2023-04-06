package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.RecordAcquisti;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.model.Registrazione;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;

@RestController
@RequestMapping("/utente")
@CrossOrigin(origins = "http://localhost:4200")
public class UtenteController {

	@Autowired
	UtenteService uteSe;
	
	@GetMapping("/ottieniutente")
	@PreAuthorize("hasRole('USER')")
	public List<Registrazione> ottieniUtente(@RequestParam int id) {
		List<Registrazione> listaFinale=new ArrayList<>();
		Utente utente=uteSe.ottieniDaId(id).get();
		Registrazione variabile=new Registrazione();
		variabile.setUsername(utente.getUsername());
		variabile.setEmail(utente.getEmail());
		variabile.setPassword(utente.getPassword());
		variabile.setNome(utente.getNome());
		variabile.setCognome(utente.getCognome());
		variabile.setDataNascita(utente.getDataNascita());
		variabile.setPortafoglio(utente.getPortafoglio());
		listaFinale.add(variabile);
		return listaFinale;
	}
	
	@GetMapping("/ottienirecordacquisti")
	@PreAuthorize("hasRole('USER')")
	public Set<RecordAcquisti> ottieniRecordAcquisti(@RequestParam int id) {
		return uteSe.ottieniDaId(id).get().getRecordAcquisti();
	}
	
	@GetMapping("/controllocorrispondenzapassword")
	public List<String> controlloCorrispondenzaPassword(@RequestParam String username, @RequestParam String pswd) {
		List<String> listaFinale=new ArrayList<>();
		Utente utente=uteSe.ottieniDaUsername(username).get();
		if(utente.getPassword().equals(pswd)) {
			listaFinale.add(utente.getNome());
		}
		return listaFinale;
	}
	
}
