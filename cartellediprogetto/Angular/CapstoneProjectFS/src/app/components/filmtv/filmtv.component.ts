import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Filmtv } from 'src/app/interfaces/filmtv';
import { FilmtvService } from 'src/app/services/filmtv.service';
import { CarrelloService } from 'src/app/services/carrello.service';
import { ListapreferitiService } from 'src/app/services/listapreferiti.service';
import { Carrello } from 'src/app/interfaces/carrello';
import { ProdottoCarrello } from 'src/app/interfaces/prodotto-carrello';

@Component({
  selector: 'app-filmtv',
  templateUrl: './filmtv.component.html',
  styleUrls: ['./filmtv.component.scss']
})
export class FilmtvComponent implements OnInit {

  public filmtvs: Filmtv[];
  token!: string | null;
  idUtente!: number;

  constructor(private filSe: FilmtvService, private carSe: CarrelloService, private lisSe: ListapreferitiService) {
    this.filmtvs = [];
  }

  ngOnInit(): void {
    if (localStorage.getItem("token")) {
      this.token = localStorage.getItem("token");
      this.idUtente = parseInt(localStorage.getItem("id")!);
    }
    this.ottieniFilmtvs();
  }

  public ottieniFilmtvs(): void {
    this.filSe.ottieniFilmtv().subscribe(
      (response: Filmtv[]) => {
        this.filmtvs = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public aggiungiAlCarrello(codice: string) {
    this.carSe.aggiungiAlCarrello(codice).subscribe();
  }

  public aggiungiAllaListaPreferiti(codice: string) {
    this.lisSe.aggiungiAllaListaPreferiti(codice)
  }

  public checkCarrello(oggetto:Filmtv){
    this.carSe.ottieniCarrello().subscribe((res:Carrello)=>{
      res.prodottoCarrello.forEach((el:ProdottoCarrello)=>{
        if(oggetto.codiceControllo===el.codiceControllo){
          return true
        }else{
          return false
        }
      })
    })
  };
}

