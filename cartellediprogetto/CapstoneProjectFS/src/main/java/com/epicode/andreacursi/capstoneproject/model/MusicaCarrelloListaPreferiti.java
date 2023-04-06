package com.epicode.andreacursi.capstoneproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicaCarrelloListaPreferiti {

	private int id;
	private String titolo;
	private double prezzo;
	private String autore;
	private String editore;
	private FormatoDisco formatoDisco;
	private String codiceControllo;
	private int quantita;
	private String immagine;
	private boolean nelCarrello;
	private boolean nellaLista;
	private boolean acquistabile;
	
}
