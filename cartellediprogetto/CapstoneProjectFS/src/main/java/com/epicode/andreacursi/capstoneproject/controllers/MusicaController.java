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

import com.epicode.andreacursi.capstoneproject.entities.Musica;
import com.epicode.andreacursi.capstoneproject.entities.ProdottoCarrello;
import com.epicode.andreacursi.capstoneproject.entities.ProdottoListaPreferiti;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.model.MusicaCarrelloListaPreferiti;
import com.epicode.andreacursi.capstoneproject.services.MusicaService;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;

@RestController
@RequestMapping("/musiche")
@CrossOrigin(origins = "http://localhost:4200")
public class MusicaController {

	@Autowired
	MusicaService musSe;
	
	@Autowired
	UtenteService uteSe;
	
	@GetMapping("/tutte")
	public List<Musica> ottieniTutti(){
		return musSe.ottieniTutti();
	}
	
	@GetMapping("/musicadaid/id={id}")
	public Optional<Musica> ottieniDaId(@PathVariable int id) {
		return musSe.ottieniDaId(id);
	}
	
	@GetMapping("/controllointeressantimusica/id={id}")
	public List<MusicaCarrelloListaPreferiti> ottieniMusicaCarrelloLista(@PathVariable int id){
		List<MusicaCarrelloListaPreferiti> listaFinale = new ArrayList<>();
		if(id!=0) {
			Utente utente = uteSe.ottieniDaId(id).get();
			Set<ProdottoCarrello> prodottiCarrello = utente.getCarrello().getProdottoCarrello();
			Set<ProdottoListaPreferiti> prodottiLista = utente.getListaPreferiti().getProdottoListaPreferiti();
			musSe.ottieniTutti().forEach((musica) -> {
				MusicaCarrelloListaPreferiti oggetto = new MusicaCarrelloListaPreferiti();
				oggetto.setId(musica.getId());
				oggetto.setTitolo(musica.getTitolo());
				oggetto.setPrezzo(musica.getPrezzo());
				oggetto.setAutore(musica.getAutore());
				oggetto.setEditore(musica.getEditore());
				oggetto.setFormatoDisco(musica.getFormatoDisco());
				oggetto.setCodiceControllo(musica.getCodiceControllo());
				oggetto.setQuantita(musica.getQuantita());
				oggetto.setImmagine(musica.getImmagine());
				
				if(!prodottiCarrello.isEmpty()) {
					Optional<ProdottoCarrello> prodCar=prodottiCarrello.stream()
							.filter(el->el.getCodiceControllo().equals(musica.getCodiceControllo())).findFirst();
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
							.filter(el->el.getCodiceControllo().equals(musica.getCodiceControllo())).findFirst();
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
				if(musica.getQuantita()<=0) {
					oggetto.setAcquistabile(false);
				}
				else {
					oggetto.setAcquistabile(true);
				}
				listaFinale.add(oggetto);
			});
		}
		else {
			musSe.ottieniTutti().forEach((musica)->{
				MusicaCarrelloListaPreferiti oggetto = new MusicaCarrelloListaPreferiti();
				oggetto.setId(musica.getId());
				oggetto.setTitolo(musica.getTitolo());
				oggetto.setPrezzo(musica.getPrezzo());
				oggetto.setAutore(musica.getAutore());
				oggetto.setEditore(musica.getEditore());
				oggetto.setFormatoDisco(musica.getFormatoDisco());
				oggetto.setCodiceControllo(musica.getCodiceControllo());
				oggetto.setQuantita(musica.getQuantita());
				oggetto.setImmagine(musica.getImmagine());
				oggetto.setNelCarrello(false);
				oggetto.setNellaLista(false);
				oggetto.setAcquistabile(true);
				listaFinale.add(oggetto);
			});
		}
		
		return listaFinale;
	}
	
}
