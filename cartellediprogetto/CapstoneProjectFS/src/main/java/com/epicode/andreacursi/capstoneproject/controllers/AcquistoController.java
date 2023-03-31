package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.Carrello;
import com.epicode.andreacursi.capstoneproject.entities.FilmTv;
import com.epicode.andreacursi.capstoneproject.entities.ProdottoCarrello;
import com.epicode.andreacursi.capstoneproject.entities.RecordAcquisti;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.services.CarrelloService;
import com.epicode.andreacursi.capstoneproject.services.FilmTvService;
import com.epicode.andreacursi.capstoneproject.services.MusicaService;
import com.epicode.andreacursi.capstoneproject.services.ProdottoCarrelloService;
import com.epicode.andreacursi.capstoneproject.services.RecordAcquistiService;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;
import com.epicode.andreacursi.capstoneproject.services.VideogiocoService;

@RestController
@RequestMapping("/acquisto")
@CrossOrigin(origins = "http://localhost:4200")
public class AcquistoController {
	
	@Autowired
	CarrelloService carSe;
	
	@Autowired
	UtenteService uteSe;
	
	@Autowired
	RecordAcquistiService recSe;
	
	@Autowired
	FilmTvService filSe;
	
	@Autowired
	MusicaService musSe;
	
	@Autowired
	VideogiocoService vidSe;
	
	@Autowired
	ProdottoCarrelloService proCaSe;

	@PostMapping("/effettuaacquisto")
	public void acquisto(@RequestParam int idUtente, @RequestParam int idCarrello, @RequestParam String data) {
		Utente utente=uteSe.ottieniDaId(idUtente).get();
		Carrello carrelloAcquistato = carSe.ottieniDaId(idCarrello).get();
		String stringa=new String();
		RecordAcquisti record= new RecordAcquisti();
		carrelloAcquistato.getProdottoCarrello().stream().forEach(el-> stringa.concat(" "+el.getTitolo()));
		
		carrelloAcquistato.getProdottoCarrello().forEach((el)->{
			if(!filSe.ottieniDaCodiceControllo(el.getCodiceControllo()).isEmpty()) {
				filSe.ottieniDaCodiceControllo(el.getCodiceControllo()).get()
				.setQuantita(filSe.ottieniDaCodiceControllo(el.getCodiceControllo())
						.get().getQuantita()-el.getQuantita());
			}
			
			if(!musSe.ottieniDaCodiceControllo(el.getCodiceControllo()).isEmpty()) {
				musSe.ottieniDaCodiceControllo(el.getCodiceControllo()).get()
				.setQuantita(musSe.ottieniDaCodiceControllo(el.getCodiceControllo())
						.get().getQuantita()-el.getQuantita());
			}
			
			if(!vidSe.ottieniDaCodiceControllo(el.getCodiceControllo()).isEmpty()) {
				vidSe.ottieniDaCodiceControllo(el.getCodiceControllo()).get()
				.setQuantita(vidSe.ottieniDaCodiceControllo(el.getCodiceControllo())
						.get().getQuantita()-el.getQuantita());
			}
			
		});
		
		record.setOggetti(stringa);
		record.setSpesa(carrelloAcquistato.getPrezzoTotale());
		record.setDataAcquisto(data);
		recSe.inserisci(record);
		if(!utente.getRecordAcquisti().isEmpty()) {
			utente.getRecordAcquisti().add(record);
		}else {
			Set<RecordAcquisti> variabile= new HashSet<>();
			variabile.add(record);
			utente.setRecordAcquisti(variabile);
		}
		utente.setPortafoglio(utente.getPortafoglio()-carrelloAcquistato.getPrezzoTotale());
		uteSe.inserisci(utente);
		Set<ProdottoCarrello> prodotti=new HashSet<>();
		prodotti.addAll(carrelloAcquistato.getProdottoCarrello());
		carrelloAcquistato.getProdottoCarrello().clear();
		carrelloAcquistato.setPrezzoTotale(0);
		carSe.inserisci(carrelloAcquistato);
		prodotti.stream().forEach((el)->{
			System.out.println(el);
			proCaSe.elimina(el.getId());
		});
		
	}
	
}
