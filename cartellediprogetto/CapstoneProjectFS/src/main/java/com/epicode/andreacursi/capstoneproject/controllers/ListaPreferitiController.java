package com.epicode.andreacursi.capstoneproject.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.capstoneproject.entities.ListaPreferiti;
import com.epicode.andreacursi.capstoneproject.entities.ProdottoListaPreferiti;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.services.FilmTvService;
import com.epicode.andreacursi.capstoneproject.services.ListaPreferitiService;
import com.epicode.andreacursi.capstoneproject.services.MusicaService;
import com.epicode.andreacursi.capstoneproject.services.ProdottoListaPreferitiService;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;
import com.epicode.andreacursi.capstoneproject.services.VideogiocoService;

@RestController
@RequestMapping("/listapreferiti")
@CrossOrigin(origins = "http://localhost:4200")
public class ListaPreferitiController {

	@Autowired
	UtenteService uteSe;

	@Autowired
	ListaPreferitiService lisSe;

	@Autowired
	FilmTvService filSe;

	@Autowired
	MusicaService musSe;

	@Autowired
	VideogiocoService vidSe;

	@Autowired
	ProdottoListaPreferitiService proLiPrSe;

	@GetMapping("/contenuto/id={id}")
	@PreAuthorize("hasRole('USER')")
	public ListaPreferiti ottieniContenutoListaPreferiti(@PathVariable int id) {
		int listaPreferitiId = uteSe.ottieniDaId(id).get().getListaPreferiti().getId();
		return lisSe.ottieniDaId(listaPreferitiId).get();
	}

	@PostMapping("/aggiungiallalistapreferiti")
	@PreAuthorize("hasRole('USER')")
	public void aggiungiAllaListaPreferiti(@RequestParam String id, @RequestParam String codice) {
		int idUtente = Integer.parseInt(id);
		List<ProdottoListaPreferiti> prodotti = new ArrayList<>();
		Utente utente = uteSe.ottieniDaId(idUtente).get();
		ListaPreferiti listaPreferiti = utente.getListaPreferiti();
		filSe.ottieniTutti().forEach((el) -> {
			if (el.getCodiceControllo().equals(codice)) {
				ProdottoListaPreferiti prodotto = new ProdottoListaPreferiti();
				prodotto.setTitolo(el.getTitolo());
				prodotto.setPrezzo(el.getPrezzo());
				prodotto.setCodiceControllo(el.getCodiceControllo());
				prodotto.setImmagine(el.getImmagine());
				prodotti.add(prodotto);
			}
		});
		musSe.ottieniTutti().forEach((el) -> {
			if (el.getCodiceControllo().equals(codice)) {
				ProdottoListaPreferiti prodotto = new ProdottoListaPreferiti();
				prodotto.setTitolo(el.getTitolo());
				prodotto.setPrezzo(el.getPrezzo());
				prodotto.setCodiceControllo(el.getCodiceControllo());
				prodotto.setImmagine(el.getImmagine());
				prodotti.add(prodotto);
			}
		});
		vidSe.ottieniTutti().forEach((el) -> {
			if (el.getCodiceControllo().equals(codice)) {
				ProdottoListaPreferiti prodotto = new ProdottoListaPreferiti();
				prodotto.setTitolo(el.getTitolo());
				prodotto.setPrezzo(el.getPrezzo());
				prodotto.setCodiceControllo(el.getCodiceControllo());
				prodotto.setImmagine(el.getImmagine());
				prodotti.add(prodotto);
			}
		});

		ProdottoListaPreferiti prodottoListaPreferiti = prodotti.get(0);
		if (!prodotti.isEmpty()) {
			if (!listaPreferiti.getProdottoListaPreferiti().isEmpty()) {
				Optional<ProdottoListaPreferiti> prodottiUtile = listaPreferiti.getProdottoListaPreferiti().stream()
						.filter(el -> el.getCodiceControllo().equals(prodottoListaPreferiti.getCodiceControllo()))
						.findFirst();
				if (prodottiUtile.isEmpty()) {
					proLiPrSe.inserisci(prodottoListaPreferiti);
					listaPreferiti.getProdottoListaPreferiti().add(prodottoListaPreferiti);
					lisSe.inserisci(listaPreferiti);
				}
			} else {
				proLiPrSe.inserisci(prodottoListaPreferiti);
				listaPreferiti.getProdottoListaPreferiti().add(prodottoListaPreferiti);
				lisSe.inserisci(listaPreferiti);
			}

		}

	}

	@DeleteMapping("/rimuovidallalistapreferiti")
	@PreAuthorize("hasRole('USER')")
	public void eliminaDallaListaPreferiti(@RequestParam int id, @RequestParam String codice) {
		int listaPreferitiId = uteSe.ottieniDaId(id).get().getListaPreferiti().getId();
		ListaPreferiti listaPreferiti = lisSe.ottieniDaId(listaPreferitiId).get();

		ProdottoListaPreferiti variabile = listaPreferiti.getProdottoListaPreferiti().stream()
				.filter(el -> el.getCodiceControllo().equals(codice)).findFirst().get();

		Optional<ProdottoListaPreferiti> prodotti = proLiPrSe.ottieniDaCodiceControllo(codice).stream()
				.filter(el -> el.getId() == variabile.getId()).findFirst();

		if (!prodotti.isEmpty()) {
			ProdottoListaPreferiti prodotto = listaPreferiti.getProdottoListaPreferiti().stream()
					.filter(el -> el.getCodiceControllo().equals(codice)).findFirst().get();
			listaPreferiti.getProdottoListaPreferiti().remove(prodotto);
			proLiPrSe.elimina(prodotto.getId());
			lisSe.inserisci(listaPreferiti);

		}
	}

}
