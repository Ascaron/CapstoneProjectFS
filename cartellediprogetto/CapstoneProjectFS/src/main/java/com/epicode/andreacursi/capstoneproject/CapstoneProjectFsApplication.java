package com.epicode.andreacursi.capstoneproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.andreacursi.capstoneproject.configuration.BeansInizialiDefiniti;
import com.epicode.andreacursi.capstoneproject.entities.FilmTv;
import com.epicode.andreacursi.capstoneproject.entities.Ruolo;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.entities.Videogioco;
import com.epicode.andreacursi.capstoneproject.services.FilmTvService;
import com.epicode.andreacursi.capstoneproject.services.RuoloService;
import com.epicode.andreacursi.capstoneproject.services.UtenteService;
import com.epicode.andreacursi.capstoneproject.services.VideogiocoService;

@SpringBootApplication
public class CapstoneProjectFsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectFsApplication.class, args);
	}
	
	@Autowired
	RuoloService ruoSe;
	
	@Autowired
	UtenteService uteSe;
	
	@Autowired
	VideogiocoService vidSe;
	
	@Autowired
	FilmTvService filSe;

	@Override
	public void run(String... args) throws Exception {
		
		//Inserimento nel database di dati preimpostati
//		inserisciBeansIniziali();
		
	}
	
	public void inserisciBeansIniziali() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeansInizialiDefiniti.class);
		
		//Ruoli
		Ruolo r1=(Ruolo)ctx.getBean("ru1");
		ruoSe.inserisci(r1);
		
		Ruolo r2=(Ruolo)ctx.getBean("ru2");
		ruoSe.inserisci(r2);
		
		//Utenti
		Utente u1=(Utente)ctx.getBean("ut1");
		uteSe.inserisci(u1);
		
		//Videogiochi
		Videogioco v1=(Videogioco)ctx.getBean("vi1");
		vidSe.inserisci(v1);
		
		Videogioco v2=(Videogioco)ctx.getBean("vi2");
		vidSe.inserisci(v2);
		
		Videogioco v3=(Videogioco)ctx.getBean("vi3");
		vidSe.inserisci(v3);
		
		Videogioco v4=(Videogioco)ctx.getBean("vi4");
		vidSe.inserisci(v4);
		
		Videogioco v5=(Videogioco)ctx.getBean("vi5");
		vidSe.inserisci(v5);
		
		//Film e Tv
		FilmTv f1=(FilmTv)ctx.getBean("fi1");
		filSe.inserisci(f1);
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
