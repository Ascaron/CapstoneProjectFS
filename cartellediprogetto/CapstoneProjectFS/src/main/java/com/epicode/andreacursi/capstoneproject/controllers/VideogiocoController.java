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

import com.epicode.andreacursi.capstoneproject.entities.ProdottoCarrello;
import com.epicode.andreacursi.capstoneproject.entities.ProdottoListaPreferiti;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.entities.Videogioco;
import com.epicode.andreacursi.capstoneproject.model.VideogiocoCarrelloListaPreferiti;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;
import com.epicode.andreacursi.capstoneproject.services.VideogiocoService;

@RestController
@RequestMapping("/videogiochi")
@CrossOrigin(origins = "http://localhost:4200")
public class VideogiocoController {

	@Autowired
	VideogiocoService vidSe;
	
	@Autowired
	UtenteService uteSe;
	
	@GetMapping("/tutti")
	public List<Videogioco> ottieniTutti(){
		return vidSe.ottieniTutti();
	}
	
	@GetMapping("/videogiocodaid/id={id}")
	public Optional<Videogioco> ottieniDaId(@PathVariable int id) {
		return vidSe.ottieniDaId(id);
	}
	
	@GetMapping("/controllointeressantivideogiochi/id={id}")
	public List<VideogiocoCarrelloListaPreferiti> ottieniVideogiocoCarrelloListaPreferiti(@PathVariable int id){
		List<VideogiocoCarrelloListaPreferiti> listaFinale = new ArrayList<>();
		if(id!=0) {
			Utente utente = uteSe.ottieniDaId(id).get();
			Set<ProdottoCarrello> prodottiCarrello = utente.getCarrello().getProdottoCarrello();
			Set<ProdottoListaPreferiti> prodottiLista = utente.getListaPreferiti().getProdottoListaPreferiti();
			vidSe.ottieniTutti().forEach((video) -> {
				VideogiocoCarrelloListaPreferiti oggetto = new VideogiocoCarrelloListaPreferiti();
				oggetto.setId(video.getId());
				oggetto.setTitolo(video.getTitolo());
				oggetto.setPrezzo(video.getPrezzo());
				oggetto.setCasaSviluppo(video.getCasaSviluppo());
				oggetto.setEditore(video.getEditore());
				oggetto.setPiattaforma(video.getPiattaforma());
				oggetto.setCodiceControllo(video.getCodiceControllo());
				oggetto.setQuantita(video.getQuantita());
				oggetto.setImmagine(video.getImmagine());
				
				if(!prodottiCarrello.isEmpty()) {
					Optional<ProdottoCarrello> prodCar=prodottiCarrello.stream()
							.filter(el->el.getCodiceControllo().equals(video.getCodiceControllo())).findFirst();
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
							.filter(el->el.getCodiceControllo().equals(video.getCodiceControllo())).findFirst();
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
				if(video.getQuantita()<=0) {
					oggetto.setAcquistabile(false);
				}
				else {
					oggetto.setAcquistabile(true);
				}
				listaFinale.add(oggetto);
			});
		}
		else {
			vidSe.ottieniTutti().forEach((video)->{
				VideogiocoCarrelloListaPreferiti oggetto = new VideogiocoCarrelloListaPreferiti();
				oggetto.setId(video.getId());
				oggetto.setTitolo(video.getTitolo());
				oggetto.setPrezzo(video.getPrezzo());
				oggetto.setCasaSviluppo(video.getCasaSviluppo());
				oggetto.setEditore(video.getEditore());
				oggetto.setPiattaforma(video.getPiattaforma());
				oggetto.setCodiceControllo(video.getCodiceControllo());
				oggetto.setQuantita(video.getQuantita());
				oggetto.setImmagine(video.getImmagine());
				oggetto.setNelCarrello(false);
				oggetto.setNellaLista(false);
				oggetto.setAcquistabile(true);
				listaFinale.add(oggetto);
			});
		}
		

		return listaFinale;
		
	}
	
}
