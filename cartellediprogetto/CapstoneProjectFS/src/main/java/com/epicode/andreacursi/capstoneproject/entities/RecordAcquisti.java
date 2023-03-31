package com.epicode.andreacursi.capstoneproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class RecordAcquisti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String oggetti;
	private double spesa;
	private String dataAcquisto;
	
}
