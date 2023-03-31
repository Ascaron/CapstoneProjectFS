package com.epicode.andreacursi.capstoneproject.configuration;

import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.andreacursi.capstoneproject.entities.Carrello;
import com.epicode.andreacursi.capstoneproject.entities.FilmTv;
import com.epicode.andreacursi.capstoneproject.entities.ListaPreferiti;
import com.epicode.andreacursi.capstoneproject.entities.Musica;
import com.epicode.andreacursi.capstoneproject.entities.Ruolo;
import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.epicode.andreacursi.capstoneproject.entities.Videogioco;
import com.epicode.andreacursi.capstoneproject.model.Formato;
import com.epicode.andreacursi.capstoneproject.model.FormatoDisco;
import com.epicode.andreacursi.capstoneproject.model.Piattaforma;
import com.epicode.andreacursi.capstoneproject.model.TipoRuolo;

@Configuration
public class BeansInizialiDefiniti {

	// Beans per Ruolo
	@Bean
	public Ruolo ru1() {
		return Ruolo.builder().tipoRuolo(TipoRuolo.ADMIN).build();
	}

	@Bean
	public Ruolo ru2() {
		return Ruolo.builder().tipoRuolo(TipoRuolo.USER).build();
	}

	// Beans per Utente Admin
	@Bean
	public Utente ut1() {
		return Utente.builder().username("mario").email("mario@rossi.it").password("mario").nome("Mario")
				.cognome("Rossi").dataNascita("1995-01-24").attivo(true).ruoli(new HashSet<>() {
					{
						add(ru1());
						add(ru2());
					}
				}).portafoglio(200).build();
	}

	// Beans per Videogioco
	@Bean
	public Videogioco vi1() {
		return Videogioco.builder().titolo("Dungeon Siege").prezzo(5).casaSviluppo("GasPowered").editore("Microsoft")
				.piattaforma(Piattaforma.PC).codiceControllo("001").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923283/CapstoneProjectFS/DungeonSiege_hbolun.jpg").build();
	}

	@Bean
	public Videogioco vi2() {
		return Videogioco.builder().titolo("Mario Kart").prezzo(5).casaSviluppo("Nintendo").editore("Nintendo")
				.piattaforma(Piattaforma.NINTENDO).codiceControllo("002").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/MarioKart_xu4mtt.jpg").build();
	}

	@Bean
	public Videogioco vi3() {
		return Videogioco.builder().titolo("T.E.S. Skyrim").prezzo(5).casaSviluppo("Bethesda").editore("Bethesda")
				.piattaforma(Piattaforma.PC).codiceControllo("003").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923285/CapstoneProjectFS/Skyrim_nh0fj4.jpg").build();
	}

	@Bean
	public Videogioco vi4() {
		return Videogioco.builder().titolo("Fifa 2015").prezzo(5).casaSviluppo("EA").editore("EA")
				.piattaforma(Piattaforma.PLAYSTATION).codiceControllo("004").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923283/CapstoneProjectFS/Fifa2015_kvngyv.jpg").build();
	}

	@Bean
	public Videogioco vi5() {
		return Videogioco.builder().titolo("Diablo 3").prezzo(5).casaSviluppo("Blizzard").editore("Blizzard")
				.piattaforma(Piattaforma.XBOX).codiceControllo("005").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923283/CapstoneProjectFS/Diablo3_ue1zyq.jpg").build();
	}

	@Bean
	public Videogioco vi6() {
		return Videogioco.builder().titolo("Diablo 2").prezzo(5).casaSviluppo("Blizzard").editore("Blizzard")
				.piattaforma(Piattaforma.PC).codiceControllo("006").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923283/CapstoneProjectFS/Diablo2_b7yp6v.jpg").build();
	}

	@Bean
	public Videogioco vi7() {
		return Videogioco.builder().titolo("Rage").prezzo(5).casaSviluppo("IdSoftware").editore("Bethesda")
				.piattaforma(Piattaforma.XBOX).codiceControllo("007").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/Rage_jpa5sj.jpg").build();
	}

	@Bean
	public Videogioco vi8() {
		return Videogioco.builder().titolo("Saints Row 2").prezzo(5).casaSviluppo("Volition").editore("THQ")
				.piattaforma(Piattaforma.PLAYSTATION).codiceControllo("008").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923285/CapstoneProjectFS/SaintsRow2_ilf7yt.jpg").build();
	}

	@Bean
	public Videogioco vi9() {
		return Videogioco.builder().titolo("Animal Crossing").prezzo(5).casaSviluppo("Nintendo").editore("Nintendo")
				.piattaforma(Piattaforma.NINTENDO).codiceControllo("009").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923282/CapstoneProjectFS/AnimalCrossing_brs0zx.jpg").build();
	}

	@Bean
	public Videogioco vi10() {
		return Videogioco.builder().titolo("Super Mario").prezzo(5).casaSviluppo("Nintendo").editore("Nintendo")
				.piattaforma(Piattaforma.NINTENDO).codiceControllo("010").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923282/CapstoneProjectFS/SuperMario_nbvblm.jpg").build();
	}

	// Beans per FilmTv
	@Bean
	public FilmTv fi1() {
		return FilmTv.builder().titolo("Robin Hood").prezzo(3).durata(120).regista("Ridley Scott")
				.attori("Russell Crowe").casaProduzione("Scott Films").formato(Formato.DVD).codiceControllo("011")
				.quantita(100).immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923285/CapstoneProjectFS/RobinHood_dtqqeg.jpg").build();
	}

	@Bean
	public FilmTv fi2() {
		return FilmTv.builder().titolo("Il Gladiatore").prezzo(3).durata(120).regista("Ridley Scott")
				.attori("Russell Crowe").casaProduzione("Scott Films").formato(Formato.BLUERAY).codiceControllo("012")
				.quantita(100).immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923283/CapstoneProjectFS/IlGladiatore_cve7kw.jpg").build();
	}

	@Bean
	public FilmTv fi3() {
		return FilmTv.builder().titolo("American Sniper").prezzo(3).durata(120).regista("Clint Eastwood")
				.attori("Bradley Cooper").casaProduzione("Warner Bros").formato(Formato.DVD).codiceControllo("013")
				.quantita(100).immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923283/CapstoneProjectFS/AmericanSniper_lez1wq.jpg").build();
	}

	@Bean
	public FilmTv fi4() {
		return FilmTv.builder().titolo("Mystic River").prezzo(3).durata(120).regista("Clint Eastwood")
				.attori("Sean Penn").casaProduzione("Warner Bros").formato(Formato.BLUERAY).codiceControllo("014")
				.quantita(100).immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/MysticRiver_pnnjim.jpg").build();
	}

	@Bean
	public FilmTv fi5() {
		return FilmTv.builder().titolo("Million Dollar Baby").prezzo(3).durata(120).regista("Clint Eastwood")
				.attori("Hilary Swank").casaProduzione("Warner Bros").formato(Formato.DVD).codiceControllo("015")
				.quantita(100).immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/MillionDollarBaby_gbc9ng.jpg").build();
	}

	@Bean
	public FilmTv fi6() {
		return FilmTv.builder().titolo("Un' ottima annata").prezzo(3).durata(120).regista("Ridley Scott")
				.attori("Russell Crowe").casaProduzione("Scott Films").formato(Formato.BLUERAY).codiceControllo("016")
				.quantita(100).immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923285/CapstoneProjectFS/UnOttimaAnnata_nssyib.jpg").build();
	}

	@Bean
	public FilmTv fi7() {
		return FilmTv.builder().titolo("American Gangster").prezzo(3).durata(120).regista("Ridley Scott")
				.attori("Denzel Washington").casaProduzione("Scott Films").formato(Formato.DVD).codiceControllo("017")
				.quantita(100).immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923282/CapstoneProjectFS/AmericanGangster_p4mbqw.jpg").build();
	}

	@Bean
	public FilmTv fi8() {
		return FilmTv.builder().titolo("Alien").prezzo(3).durata(120).regista("Ridley Scott").attori("Sigourney Weaver")
				.casaProduzione("Scott Films").formato(Formato.BLUERAY).codiceControllo("018").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923282/CapstoneProjectFS/Alien_fxpldd.jpg").build();
	}

	@Bean
	public FilmTv fi9() {
		return FilmTv.builder().titolo("Blade Runner").prezzo(3).durata(120).regista("Ridley Scott")
				.attori("Harrison Ford").casaProduzione("Scott Films").formato(Formato.DVD).codiceControllo("019")
				.quantita(100).immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923286/CapstoneProjectFS/BladeRunner_expusu.jpg").build();
	}

	@Bean
	public FilmTv fi10() {
		return FilmTv.builder().titolo("Le crociate - Kingdom of Heaven").prezzo(3).durata(120).regista("Ridley Scott")
				.attori("Orlando Bloom").casaProduzione("Scott Films").formato(Formato.BLUERAY).codiceControllo("020")
				.quantita(100).immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/LeCrociate_xs3zjg.jpg").build();
	}

	// Beans per Musica
	@Bean
	public Musica mu1() {
		return Musica.builder().titolo("La seconda rivoluzione sessuale").prezzo(5).autore("Tre Allegri Ragazzi Morti")
				.editore("La Tempesta Dischi").formatoDisco(FormatoDisco.CD).codiceControllo("021").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923283/CapstoneProjectFS/LaSecondaRivoluzioneSessuale_elg0br.jpg").build();
	}

	@Bean
	public Musica mu2() {
		return Musica.builder().titolo("Nel giardino dei fantasmi").prezzo(5).autore("Tre Allegri Ragazzi Morti")
				.editore("La Tempesta Dischi").formatoDisco(FormatoDisco.VINILE).codiceControllo("022").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/NelGiardinoDeiFantasmi_evxtt2.jpg").build();
	}

	@Bean
	public Musica mu3() {
		return Musica.builder().titolo("Inumani").prezzo(5).autore("Tre Allegri Ragazzi Morti")
				.editore("La Tempesta Dischi").formatoDisco(FormatoDisco.CD).codiceControllo("023").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/Inumani_rlls5f.jpg").build();
	}

	@Bean
	public Musica mu4() {
		return Musica.builder().titolo("Mostri e normali").prezzo(5).autore("Tre Allegri Ragazzi Morti")
				.editore("La Tempesta Dischi").formatoDisco(FormatoDisco.VINILE).codiceControllo("024").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/MostriENormali_shgzzx.jpg").build();
	}

	@Bean
	public Musica mu5() {
		return Musica.builder().titolo("La testa indipendente").prezzo(5).autore("Tre Allegri Ragazzi Morti")
				.editore("La Tempesta Dischi").formatoDisco(FormatoDisco.CD).codiceControllo("025").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923283/CapstoneProjectFS/LaTestaIndipendente_kjicne.jpg").build();
	}

	@Bean
	public Musica mu6() {
		return Musica.builder().titolo("Meme K Ultra").prezzo(5).autore("Tre Allegri Ragazzi Morti")
				.editore("La Tempesta Dischi").formatoDisco(FormatoDisco.VINILE).codiceControllo("026").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/MemeKUltra_uv9iex.jpg").build();
	}

	@Bean
	public Musica mu7() {
		return Musica.builder().titolo("Sindacato dei sogni").prezzo(5).autore("Tre Allegri Ragazzi Morti")
				.editore("La Tempesta Dischi").formatoDisco(FormatoDisco.CD).codiceControllo("027").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923285/CapstoneProjectFS/SindacatoDeiSogni_kes4hg.jpg").build();
	}

	@Bean
	public Musica mu8() {
		return Musica.builder().titolo("Primitivi del futuro").prezzo(5).autore("Tre Allegri Ragazzi Morti")
				.editore("La Tempesta Dischi").formatoDisco(FormatoDisco.VINILE).codiceControllo("028").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923284/CapstoneProjectFS/PrimitiviDelFuturo_qpc2gm.jpg").build();
	}

	@Bean
	public Musica mu9() {
		return Musica.builder().titolo("23 6451").prezzo(5).autore("Tha Supreme").editore("SONY")
				.formatoDisco(FormatoDisco.CD).codiceControllo("029").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923283/CapstoneProjectFS/LeBasi_is1ugs.jpg").build();
	}

	@Bean
	public Musica mu10() {
		return Musica.builder().titolo("carattere speciale").prezzo(5).autore("Tha Supreme").editore("SONY")
				.formatoDisco(FormatoDisco.CD).codiceControllo("030").quantita(100)
				.immagine("https://res.cloudinary.com/do9itdkzg/image/upload/v1679923282/CapstoneProjectFS/CarattereSpeciale_lyg0fc.jpg").build();
	}
	
	// Beans per Carrello
	@Bean 
	public Carrello ca1() {
		return Carrello.builder().build();
	}
	
	// Beans per ListaPreferiti
	@Bean 
	public ListaPreferiti li1() {
		return ListaPreferiti.builder().build();
	}
	
	// Beans per utente User
	@Bean
	public Utente ut2() {
		return Utente.builder().username("luigi").email("luigi@verdi.it").password("luigi").nome("Luigi")
				.cognome("Verdi").dataNascita("1990-03-27").attivo(true).ruoli(new HashSet<>() {
					{
						add(ru2());
					}
				}).portafoglio(100).carrello(ca1()).listaPreferiti(li1()).build();
	}
}
