package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.FilmTv;
import com.epicode.andreacursi.capstoneproject.entities.ProdottoCarrello;
import com.epicode.andreacursi.capstoneproject.entities.ProdottoListaPreferiti;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.model.FilmTvCarrelloListaPreferiti;
import com.epicode.andreacursi.capstoneproject.services.CarrelloService;
import com.epicode.andreacursi.capstoneproject.services.FilmTvService;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;

@RestController
@RequestMapping("/filmtv")
@CrossOrigin(origins = "http://localhost:4200")
public class FilmTvController {

	@Autowired
	FilmTvService filSe;

	@Autowired
	UtenteService uteSe;
	
	@Autowired
	CarrelloService carSe;

	@GetMapping("/tutti")
	public List<FilmTv> ottieniTutti() {
		return filSe.ottieniTutti();
	}

	@GetMapping("/filmtvdaid/id={id}")
	public Optional<FilmTv> ottieniDaId(@PathVariable int id) {
		return filSe.ottieniDaId(id);
	}

	@GetMapping("/controllointeressantifilmtv/id={id}")
	public List<FilmTvCarrelloListaPreferiti> ottieniFilmTvCarrelloLista(@PathVariable int id) {
		List<FilmTvCarrelloListaPreferiti> listaFinale = new ArrayList<>();
		if (id!=0) {
			Utente utente = uteSe.ottieniDaId(id).get();
			Set<ProdottoCarrello> prodottiCarrello = utente.getCarrello().getProdottoCarrello();
			Set<ProdottoListaPreferiti> prodottiLista = utente.getListaPreferiti().getProdottoListaPreferiti();
			filSe.ottieniTutti().forEach((film) -> {
				FilmTvCarrelloListaPreferiti oggetto = new FilmTvCarrelloListaPreferiti();
				oggetto.setId(film.getId());
				oggetto.setTitolo(film.getTitolo());
				oggetto.setPrezzo(film.getPrezzo());
				oggetto.setDurata(film.getDurata());
				oggetto.setRegista(film.getRegista());
				oggetto.setAttori(film.getAttori());
				oggetto.setCasaProduzione(film.getCasaProduzione());
				oggetto.setFormato(film.getFormato());
				oggetto.setCodiceControllo(film.getCodiceControllo());
				oggetto.setQuantita(film.getQuantita());
				oggetto.setImmagine(film.getImmagine());
				
				if(!prodottiCarrello.isEmpty()) {
					Optional<ProdottoCarrello> prodCar=prodottiCarrello.stream()
							.filter(el->el.getCodiceControllo().equals(film.getCodiceControllo())).findFirst();
					if(!prodCar.isEmpty()) {
						oggetto.setNelCarrello(true);
					}
					else {
						oggetto.setNelCarrello(false);
					}
				}
				else {
					oggetto.setNelCarrello(false);
				}
				
				if(!prodottiLista.isEmpty()) {
					Optional<ProdottoListaPreferiti> prodLis=prodottiLista.stream()
							.filter(el->el.getCodiceControllo().equals(film.getCodiceControllo())).findFirst();
					if(!prodLis.isEmpty()) {
						oggetto.setNellaLista(true);
					}
					else {
						oggetto.setNellaLista(false);
					}
				}
				else {
					oggetto.setNellaLista(false);
				}
				if(film.getQuantita()<=0) {
					oggetto.setAcquistabile(false);
				}
				else {
					oggetto.setAcquistabile(true);
				}
				listaFinale.add(oggetto);
			});
		}
		else {
			filSe.ottieniTutti().forEach((film)->{
				FilmTvCarrelloListaPreferiti oggetto = new FilmTvCarrelloListaPreferiti();
				oggetto.setId(film.getId());
				oggetto.setTitolo(film.getTitolo());
				oggetto.setPrezzo(film.getPrezzo());
				oggetto.setDurata(film.getDurata());
				oggetto.setRegista(film.getRegista());
				oggetto.setAttori(film.getAttori());
				oggetto.setCasaProduzione(film.getCasaProduzione());
				oggetto.setFormato(film.getFormato());
				oggetto.setCodiceControllo(film.getCodiceControllo());
				oggetto.setQuantita(film.getQuantita());
				oggetto.setImmagine(film.getImmagine());
				oggetto.setNelCarrello(false);
				oggetto.setNellaLista(false);
				oggetto.setAcquistabile(true);
				listaFinale.add(oggetto);
			});
		}

		return listaFinale;
	}
}
