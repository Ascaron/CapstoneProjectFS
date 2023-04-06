import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { MusicaCarrelloListaPreferiti } from 'src/app/interfaces/musica';
import { MusicaService } from 'src/app/services/musica.service';
import { CarrelloService } from 'src/app/services/carrello.service';
import { ListapreferitiService } from 'src/app/services/listapreferiti.service';

@Component({
  selector: 'app-musica',
  templateUrl: './musica.component.html',
  styleUrls: ['./musica.component.scss']
})
export class MusicaComponent implements OnInit {

  public musiche:MusicaCarrelloListaPreferiti[];
  token!:string | null;
  idUtente!: number;

  constructor(private musSe: MusicaService, private carSe:CarrelloService, private lisSe:ListapreferitiService) {
    this.musiche=[];
   }

  ngOnInit(): void {
    if(localStorage.getItem("token")){
      this.token=localStorage.getItem("token");
      this.idUtente = parseInt(localStorage.getItem("id")!);
      this.ottieniMusiche(this.idUtente);
    }
    else{
      this.ottieniMusiche(0);
    }

  }

  public ottieniMusiche(valore:number): void {
    this.musSe.ottieniMusicaCarrelloLista(valore).subscribe(
      (response: MusicaCarrelloListaPreferiti[]) => {
        this.musiche = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
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
