package com.epicode.andreacursi.capstoneproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideogiocoCarrelloListaPreferiti {

	private int id;
	private String titolo;
	private double prezzo;
	private String casaSviluppo;
	private String editore;
	private Piattaforma piattaforma;
	private String codiceControllo;
	private int quantita;
	private String immagine;
	private boolean nelCarrello;
	private boolean nellaLista;
	private boolean acquistabile;
	
}
