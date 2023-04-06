import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FilmTvCarrelloListaPreferiti } from 'src/app/interfaces/filmtv';
import { FilmtvService } from 'src/app/services/filmtv.service';
import { CarrelloService } from 'src/app/services/carrello.service';
import { ListapreferitiService } from 'src/app/services/listapreferiti.service';

@Component({
  selector: 'app-filmtv',
  templateUrl: './filmtv.component.html',
  styleUrls: ['./filmtv.component.scss']
})
export class FilmtvComponent implements OnInit {

  public filmtvs: FilmTvCarrelloListaPreferiti[];
  token!: string | null;
  idUtente!: number;

  constructor(private filSe: FilmtvService, private carSe: CarrelloService, private lisSe: ListapreferitiService) {
    this.filmtvs = [];
  }

  ngOnInit(): void {
    if (localStorage.getItem("token")) {
      this.token = localStorage.getItem("token");
      this.idUtente = parseInt(localStorage.getItem("id")!);
      this.ottieniFilmTv(this.idUtente);
    }
    else {
      this.ottieniFilmTv(0);
    }
  }

  public ottieniFilmTv(valore:number):void{
    this.filSe.ottieniFilmTvCarrelloLista(valore).subscribe((res:FilmTvCarrelloListaPreferiti[])=>{
      this.filmtvs = res;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    })
  }

  public ricaricaPagina(){
    window.location.reload();
  }

  public aggiungiAlCarrello(codice: string) {
    this.carSe.aggiungiAlCarrello(codice).subscribe();
  }

  public aggiungiAllaListaPreferiti(codice: string) {
    this.lisSe.aggiungiAllaListaPreferiti(codice).subscribe();
  }

  public rimuoviDallaListaPreferiti(codice:string){
    this.lisSe.rimuoviDallaListaPreferiti(codice).subscribe();
  }

}
