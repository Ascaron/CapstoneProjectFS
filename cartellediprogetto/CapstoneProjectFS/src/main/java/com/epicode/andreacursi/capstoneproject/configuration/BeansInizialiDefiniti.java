package com.epicode.andreacursi.capstoneproject.configuration;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.epicode.andreacursi.capstoneproject.entities.FilmTv;
import com.epicode.andreacursi.capstoneproject.entities.Ruolo;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.entities.Videogioco;
import com.epicode.andreacursi.capstoneproject.model.Formato;
import com.epicode.andreacursi.capstoneproject.model.Piattaforma;
import com.epicode.andreacursi.capstoneproject.model.TipoRuolo;

@Configuration
public class BeansInizialiDefiniti {

	//Beans per Ruolo
		@Bean
		public Ruolo ru1() {
			return Ruolo.builder().tipoRuolo(TipoRuolo.ADMIN).build();
		}
		
		@Bean
		public Ruolo ru2() {
			return Ruolo.builder().tipoRuolo(TipoRuolo.USER).build();
		}
		
		//Beans per Utente
		@Bean
		public Utente ut1() {
			return Utente.builder().username("mario").email("mario@rossi.it")
					.password("mario").nome("Mario")
					.cognome("Rossi").dataNascita(LocalDate.of(1995, 01, 24)).attivo(true)
					.ruoli(new HashSet<>(){{add(ru1()); add(ru2());}}).portafoglio(200).build();
		}
		
		//Beans per Videogioco
		@Bean
		public Videogioco vi1() {
			return Videogioco.builder().titolo("Dungeon Siege").prezzo(5).casaSviluppo("GasPowered")
					.editore("Microsoft").piattaforma(Piattaforma.PC).build();
		}
		
		@Bean
		public Videogioco vi2() {
			return Videogioco.builder().titolo("Matio Kart").prezzo(5).casaSviluppo("Nintendo")
					.editore("Nintendo").piattaforma(Piattaforma.NINTENDO).build();
		}
		
		@Bean
		public Videogioco vi3() {
			return Videogioco.builder().titolo("T.E.S. Skyrim").prezzo(5).casaSviluppo("Bethesda")
					.editore("Bethesda").piattaforma(Piattaforma.PC).build();
		}
		
		@Bean
		public Videogioco vi4() {
			return Videogioco.builder().titolo("Fifa 2015").prezzo(5).casaSviluppo("EA")
					.editore("EA").piattaforma(Piattaforma.PLAYSTATION).build();
		}
		
		@Bean
		public Videogioco vi5() {
			return Videogioco.builder().titolo("Diablo 3").prezzo(5).casaSviluppo("Blizzard")
					.editore("Blizzard").piattaforma(Piattaforma.XBOX).build();
		}
		
		//Beans per FilmTv
		@Bean
		public FilmTv fi1() {
			return FilmTv.builder().titolo("Robin Hood").prezzo(10).durata(120)
					.regista("Ridley Scott").attori("Russell Crowe").casaProduzione("Scott Films")
					.formato(Formato.DVD).build();
		}
	
}
