package com.epicode.andreacursi.capstoneproject.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.epicode.andreacursi.capstoneproject.model.Formato;

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
public class FilmTv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titolo;
	private double prezzo;
	private int durata;
	private String regista;
	private String attori;
	private String casaProduzione;
	@Enumerated(EnumType.STRING)
	private Formato formato;
	
}
