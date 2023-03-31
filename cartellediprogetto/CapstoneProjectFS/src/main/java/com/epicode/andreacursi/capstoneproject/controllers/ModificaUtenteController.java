package com.epicode.andreacursi.capstoneproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.model.Registrazione;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;

@RestController
@RequestMapping("/modifica")
@CrossOrigin(origins = "http://localhost:4200")
public class ModificaUtenteController {
	
	@Autowired
	UtenteService uteSe;
	
	@PutMapping("/modificautente")
	public void modificaUtente(@RequestBody Registrazione registrazione, @RequestParam int id) {
		Utente utente= uteSe.ottieniDaId(id).get();
		utente.setUsername(registrazione.getUsername());
		utente.setEmail(registrazione.getEmail());
		utente.setPassword(registrazione.getPassword());
		utente.setNome(registrazione.getNome());
		utente.setCognome(registrazione.getCognome());
		utente.setDataNascita(registrazione.getDataNascita());
		utente.setPortafoglio(utente.getPortafoglio()+registrazione.getPortafoglio());
		uteSe.inserisci(utente);
		
	}

}
