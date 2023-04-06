package com.epicode.andreacursi.capstoneproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdottoCarrelloAcquistabile {

	private int id;
	private String titolo;
	private double prezzo;
	private String codiceControllo;
	private int quantita;
	private String immagine;
	private boolean acquistabile;
	
}
