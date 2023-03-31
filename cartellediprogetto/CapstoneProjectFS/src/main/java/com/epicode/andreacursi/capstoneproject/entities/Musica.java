package com.epicode.andreacursi.capstoneproject.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.epicode.andreacursi.capstoneproject.model.FormatoDisco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titolo;
	private double prezzo;
	private String autore;
	private String editore;
	@Enumerated(EnumType.STRING)
	private FormatoDisco formatoDisco;
	private String codiceControllo;
	private int quantita;
	private String immagine;
	
}
