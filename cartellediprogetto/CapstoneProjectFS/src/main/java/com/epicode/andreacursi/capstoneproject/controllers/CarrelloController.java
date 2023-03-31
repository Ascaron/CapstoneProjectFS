package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.Carrello;
import com.epicode.andreacursi.capstoneproject.entities.FilmTv;
import com.epicode.andreacursi.capstoneproject.entities.Musica;
import com.epicode.andreacursi.capstoneproject.entities.ProdottoCarrello;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.entities.Videogioco;
import com.epicode.andreacursi.capstoneproject.model.AggiungiProdotto;
import com.epicode.andreacursi.capstoneproject.services.CarrelloService;
import com.epicode.andreacursi.capstoneproject.services.FilmTvService;
import com.epicode.andreacursi.capstoneproject.services.MusicaService;
import com.epicode.andreacursi.capstoneproject.services.ProdottoCarrelloService;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;
import com.epicode.andreacursi.capstoneproject.services.VideogiocoService;

@RestController
@RequestMapping("/carrello")
@CrossOrigin(origins = "http://localhost:4200")
public class CarrelloController {

	@Autowired
	UtenteService uteSe;

	@Autowired
	CarrelloService carSe;

	@Autowired
	FilmTvService filSe;

	@Autowired
	MusicaService musSe;

	@Autowired
	VideogiocoService vidSe;

	@Autowired
	ProdottoCarrelloService proCaSe;

	@GetMapping("/contenuto/id={id}")
	public Carrello ottieniContenutoCarrello(@PathVariable int id) {
		int carrelloId = uteSe.ottieniDaId(id).get().getCarrello().getId();
		return carSe.ottieniDaId(carrelloId).get();
	}

	@PostMapping("/aggiungialcarrello")
	public void aggiungiAlCarrello(@RequestParam String id, @RequestParam String codice) {
		int idUtente = Integer.parseInt(id);
		List<ProdottoCarrello> prodotti = new ArrayList<>();
		Utente utente = uteSe.ottieniDaId(idUtente).get();
		Carrello carrello = utente.getCarrello();
		filSe.ottieniTutti().forEach((el) -> {
			if (el.getCodiceControllo().equals(codice)) {
				ProdottoCarrello prodotto = new ProdottoCarrello();
				prodotto.setTitolo(el.getTitolo());
				prodotto.setPrezzo(el.getPrezzo());
				prodotto.setCodiceControllo(el.getCodiceControllo());
				prodotto.setQuantita(1);
				prodotto.setImmagine(el.getImmagine());
				prodotti.add(prodotto);
			}
		});
		musSe.ottieniTutti().forEach((el) -> {
			if (el.getCodiceControllo().equals(codice)) {
				ProdottoCarrello prodotto = new ProdottoCarrello();
				prodotto.setTitolo(el.getTitolo());
				prodotto.setPrezzo(el.getPrezzo());
				prodotto.setCodiceControllo(el.getCodiceControllo());
				prodotto.setQuantita(1);
				prodotto.setImmagine(el.getImmagine());
				prodotti.add(prodotto);
			}
		});
		vidSe.ottieniTutti().forEach((el) -> {
			if (el.getCodiceControllo().equals(codice)) {
				ProdottoCarrello prodotto = new ProdottoCarrello();
				prodotto.setTitolo(el.getTitolo());
				prodotto.setPrezzo(el.getPrezzo());
				prodotto.setCodiceControllo(el.getCodiceControllo());
				prodotto.setQuantita(1);
				prodotto.setImmagine(el.getImmagine());
				prodotti.add(prodotto);
			}
		});
		ProdottoCarrello prodottoCarrello = prodotti.get(0);
		if (!prodotti.isEmpty()) {
			if (!carrello.getProdottoCarrello().isEmpty()) {
				Optional<ProdottoCarrello> prodottiUtile = carrello.getProdottoCarrello().stream()
						.filter(el -> el.getCodiceControllo().equals(prodottoCarrello.getCodiceControllo()))
						.findFirst();
				if (!prodottiUtile.isEmpty()) {
					ProdottoCarrello variabile = carrello.getProdottoCarrello().stream()
							.filter(el -> el.getCodiceControllo().equals(prodottoCarrello.getCodiceControllo()))
							.findFirst().get();
					variabile.setQuantita(variabile.getQuantita() + 1);
					carrello.setPrezzoTotale(carrello.getPrezzoTotale() + variabile.getPrezzo() + 2);
					carSe.inserisci(carrello);
				} else {
					proCaSe.inserisci(prodottoCarrello);
					carrello.getProdottoCarrello().add(prodottoCarrello);
					carrello.setPrezzoTotale(carrello.getPrezzoTotale() + prodottoCarrello.getPrezzo() + 2);
					carSe.inserisci(carrello);
				}
			} else {
				proCaSe.inserisci(prodottoCarrello);
				carrello.getProdottoCarrello().add(prodottoCarrello);
				carrello.setPrezzoTotale(carrello.getPrezzoTotale() + prodottoCarrello.getPrezzo() + 2);
				carSe.inserisci(carrello);
			}

		}

	}

	@DeleteMapping("/rimuovidalcarrello")
	public void eliminaDaCarrello(@RequestParam int id, @RequestParam String codice) {
		int carrelloId = uteSe.ottieniDaId(id).get().getCarrello().getId();
		Carrello carrello = carSe.ottieniDaId(carrelloId).get();

		ProdottoCarrello variabile = carrello.getProdottoCarrello().stream()
				.filter(el -> el.getCodiceControllo().equals(codice)).findFirst().get();

		Optional<ProdottoCarrello> prodotti = proCaSe.ottieniDaCodiceControllo(codice).stream()
				.filter(el -> el.getId() == variabile.getId()).findFirst();

		if (!prodotti.isEmpty()) {
			ProdottoCarrello prodotto = carrello.getProdottoCarrello().stream()
					.filter(el -> el.getCodiceControllo().equals(codice)).findFirst().get();
			if (prodotto.getQuantita() > 1) {
				prodotto.setQuantita(prodotto.getQuantita() - 1);
				carrello.setPrezzoTotale(carrello.getPrezzoTotale() - prodotto.getPrezzo() - 2);
				carSe.inserisci(carrello);
			} else {
				carrello.getProdottoCarrello().remove(prodotto);
				carrello.setPrezzoTotale(carrello.getPrezzoTotale() - prodotto.getPrezzo() - 2);
				proCaSe.elimina(prodotto.getId());
				carSe.inserisci(carrello);
			}
		}

	}

	@GetMapping("/ottieniprodottonelcarrelloutente={id}&codice={codice}")
	public ProdottoCarrello ottieniFilmTvNelCarrello(@PathVariable int id, @PathVariable String codice) {
		int carrelloId = uteSe.ottieniDaId(id).get().getCarrello().getId();
		Set<ProdottoCarrello> carrelloProdotti= carSe.ottieniDaId(carrelloId).get().getProdottoCarrello();
		List<ProdottoCarrello> prodotti=new ArrayList<>();
		carrelloProdotti.forEach((el)->{
			if(el.getCodiceControllo().equals(codice)) {
				prodotti.add(el);
			}
		});
		return prodotti.get(0);
	}

}
