package com.epicode.andreacursi.capstoneproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.andreacursi.capstoneproject.configuration.BeansInizialiDefiniti;
import com.epicode.andreacursi.capstoneproject.entities.Carrello;
import com.epicode.andreacursi.capstoneproject.entities.FilmTv;
import com.epicode.andreacursi.capstoneproject.entities.ListaPreferiti;
import com.epicode.andreacursi.capstoneproject.entities.Musica;
import com.epicode.andreacursi.capstoneproject.entities.Ruolo;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.entities.Videogioco;
import com.epicode.andreacursi.capstoneproject.services.CarrelloService;
import com.epicode.andreacursi.capstoneproject.services.FilmTvService;
import com.epicode.andreacursi.capstoneproject.services.ListaPreferitiService;
import com.epicode.andreacursi.capstoneproject.services.MusicaService;
import com.epicode.andreacursi.capstoneproject.services.RecordAcquistiService;
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
	
	@Autowired
	MusicaService musSe;
	
	@Autowired
	CarrelloService carSe;
	
	@Autowired
	ListaPreferitiService lisSe;
	
	@Autowired
	RecordAcquistiService recSe;

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
		
		Videogioco v6=(Videogioco)ctx.getBean("vi6");
		vidSe.inserisci(v6);
		
		Videogioco v7=(Videogioco)ctx.getBean("vi7");
		vidSe.inserisci(v7);
		
		Videogioco v8=(Videogioco)ctx.getBean("vi8");
		vidSe.inserisci(v8);
		
		Videogioco v9=(Videogioco)ctx.getBean("vi9");
		vidSe.inserisci(v9);
		
		Videogioco v10=(Videogioco)ctx.getBean("vi10");
		vidSe.inserisci(v10);
		
		//Film e Tv
		FilmTv f1=(FilmTv)ctx.getBean("fi1");
		filSe.inserisci(f1);
		
		FilmTv f2=(FilmTv)ctx.getBean("fi2");
		filSe.inserisci(f2);
		
		FilmTv f3=(FilmTv)ctx.getBean("fi3");
		filSe.inserisci(f3);
		
		FilmTv f4=(FilmTv)ctx.getBean("fi4");
		filSe.inserisci(f4);
		
		FilmTv f5=(FilmTv)ctx.getBean("fi5");
		filSe.inserisci(f5);
		
		FilmTv f6=(FilmTv)ctx.getBean("fi6");
		filSe.inserisci(f6);
		
		FilmTv f7=(FilmTv)ctx.getBean("fi7");
		filSe.inserisci(f7);
		
		FilmTv f8=(FilmTv)ctx.getBean("fi8");
		filSe.inserisci(f8);
		
		FilmTv f9=(FilmTv)ctx.getBean("fi9");
		filSe.inserisci(f9);
		
		FilmTv f10=(FilmTv)ctx.getBean("fi10");
		filSe.inserisci(f10);
		
		//Musica
		Musica m1=(Musica)ctx.getBean("mu1");
		musSe.inserisci(m1);
		
		Musica m2=(Musica)ctx.getBean("mu2");
		musSe.inserisci(m2);
		
		Musica m3=(Musica)ctx.getBean("mu3");
		musSe.inserisci(m3);
		
		Musica m4=(Musica)ctx.getBean("mu4");
		musSe.inserisci(m4);
		
		Musica m5=(Musica)ctx.getBean("mu5");
		musSe.inserisci(m5);
		
		Musica m6=(Musica)ctx.getBean("mu6");
		musSe.inserisci(m6);
		
		Musica m7=(Musica)ctx.getBean("mu7");
		musSe.inserisci(m7);
		
		Musica m8=(Musica)ctx.getBean("mu8");
		musSe.inserisci(m8);
		
		Musica m9=(Musica)ctx.getBean("mu9");
		musSe.inserisci(m9);
		
		Musica m10=(Musica)ctx.getBean("mu10");
		musSe.inserisci(m10);
		
		//Users di prova
		Carrello c1=(Carrello)ctx.getBean("ca1");
		carSe.inserisci(c1);
		
		Carrello c2=(Carrello)ctx.getBean("ca2");
		carSe.inserisci(c2);
		
		ListaPreferiti l1=(ListaPreferiti)ctx.getBean("li1");
		lisSe.inserisci(l1);
		
		ListaPreferiti l2=(ListaPreferiti)ctx.getBean("li2");
		lisSe.inserisci(l2);
		
		//Utente admin
		Utente u1=(Utente)ctx.getBean("ut1");
		uteSe.inserisci(u1);
		
		//Utente user
		Utente u2=(Utente)ctx.getBean("ut2");
		uteSe.inserisci(u2);
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
