package com.epicode.andreacursi.capstoneproject.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String dataNascita;
	private Boolean attivo;
	@OneToOne
	private ListaPreferiti listaPreferiti;
	@OneToOne
	private Carrello carrello;
	@ManyToMany
	private Set<RecordAcquisti> recordAcquisti;
	@ManyToMany
	private Set<Ruolo> ruoli=new HashSet<>();
	private double portafoglio;
	
}
