import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { VideogiocoCarrelloListaPreferiti } from 'src/app/interfaces/videogioco';
import { VideogiocoService } from 'src/app/services/videogioco.service';
import { CarrelloService } from 'src/app/services/carrello.service';
import { ListapreferitiService } from 'src/app/services/listapreferiti.service';

@Component({
  selector: 'app-videogioco',
  templateUrl: './videogioco.component.html',
  styleUrls: ['./videogioco.component.scss']
})
export class VideogiocoComponent implements OnInit {

  public videogiochi: VideogiocoCarrelloListaPreferiti[];
  token!:string | null
  idUtente!: number;

  constructor(private videogiocoService: VideogiocoService, private carSe:CarrelloService, private lisSe:ListapreferitiService) {
    this.videogiochi = [];
  }

  ngOnInit(): void {
    if(localStorage.getItem("token")){
      this.token=localStorage.getItem("token");
      this.idUtente = parseInt(localStorage.getItem("id")!);
      this.ottieniVideogiochi(this.idUtente);
    }
    else{
      this.ottieniVideogiochi(0);
    }
  }

  public ottieniVideogiochi(valore:number): void {
    this.videogiocoService.ottieniVideogiocoCarrelloListaPreferiti(valore).subscribe(
      (response: VideogiocoCarrelloListaPreferiti[]) => {
        this.videogiochi = response;
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
