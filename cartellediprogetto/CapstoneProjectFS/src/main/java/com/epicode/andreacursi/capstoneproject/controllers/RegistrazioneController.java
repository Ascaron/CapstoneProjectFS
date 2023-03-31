package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.Carrello;
import com.epicode.andreacursi.capstoneproject.entities.ListaPreferiti;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.model.Registrazione;
import com.epicode.andreacursi.capstoneproject.services.CarrelloService;
import com.epicode.andreacursi.capstoneproject.services.ListaPreferitiService;
import com.epicode.andreacursi.capstoneproject.services.RecordAcquistiService;
import com.epicode.andreacursi.capstoneproject.services.RuoloService;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;

@RestController
@RequestMapping("/registrazione")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrazioneController {
	
	@Autowired
	UtenteService uteSe;
	
	@Autowired
	RuoloService ruoSe;
	
	@Autowired
	CarrelloService carSe;
	
	@Autowired
	ListaPreferitiService lisSe;
	
	@Autowired
	RecordAcquistiService resSe;
	
	@PostMapping("/registrautente")
	public void registraUtente(@RequestBody Registrazione registrazione) {
		
		Carrello carrello=new Carrello();
		carSe.inserisci(carrello);
		
		ListaPreferiti lista= new ListaPreferiti();
		lisSe.inserisci(lista);
		
		Utente utente=new Utente();
		utente.setUsername(registrazione.getUsername());
		utente.setEmail(registrazione.getEmail());
		utente.setPassword(registrazione.getPassword());
		utente.setNome(registrazione.getNome());
		utente.setCognome(registrazione.getCognome());
		utente.setDataNascita(registrazione.getDataNascita());
		utente.setAttivo(true);
		utente.setRuoli(new HashSet<>() {{add(ruoSe.ottieniDaId(2).get());}});
		utente.setPortafoglio(registrazione.getPortafoglio());
		utente.setCarrello(carSe.ottieniTutti().get(carSe.ottieniTutti().size()-1));
		utente.setListaPreferiti(lisSe.ottieniTutti().get(lisSe.ottieniTutti().size()-1));
		utente.setRecordAcquisti(new HashSet<>());
		uteSe.inserisci(utente);
	}

}
