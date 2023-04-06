package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	@PreAuthorize("hasRole('USER')")
	public void modificaUtente(@RequestBody Registrazione registrazione, @RequestParam int id) {
		Utente utente= uteSe.ottieniDaId(id).get();
		utente.setUsername(registrazione.getUsername());
		utente.setEmail(registrazione.getEmail());
		utente.setPassword(registrazione.getPassword());
		utente.setNome(registrazione.getNome());
		utente.setCognome(registrazione.getCognome());
		utente.setDataNascita(registrazione.getDataNascita());
		if(registrazione.getPortafoglio()<0) {
			registrazione.setPortafoglio(0);
		}
		utente.setPortafoglio(utente.getPortafoglio()+registrazione.getPortafoglio());
		uteSe.inserisci(utente);
		
	}
	
	@GetMapping("/controlloesistenzausername")
	public List<String> controlloEsistenzaUsername(@RequestParam String username, @RequestParam int id) {
		List<String> utenti=new ArrayList<>();
		if(id!=0) {
			Utente uteLog=uteSe.ottieniDaId(id).get();
			if(uteLog.getUsername().equals(username)) {
				return utenti;
			}
			else {
				uteSe.ottieniTutti().forEach((utente)->{
					if(utente.getUsername().equals(username)) {
						utenti.add(utente.getUsername());
					}
				});
				return utenti;
			}
		}
		else {
			uteSe.ottieniTutti().forEach((utente)->{
				if(utente.getUsername().equals(username)) {
					utenti.add(utente.getUsername());
				}
			});
			return utenti;
		}
	}

}
