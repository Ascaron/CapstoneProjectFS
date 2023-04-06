package com.epicode.andreacursi.capstoneproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmTvCarrelloListaPreferiti {

	private int id;
	private String titolo;
	private double prezzo;
	private int durata;
	private String regista;
	private String attori;
	private String casaProduzione;
	private Formato formato;
	private String codiceControllo;
	private int quantita;
	private String immagine;
	private boolean nelCarrello;
	private boolean nellaLista;
	private boolean acquistabile;
	
}
