import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Musica } from 'src/app/interfaces/musica';
import { MusicaService } from 'src/app/services/musica.service';
import { CarrelloService } from 'src/app/services/carrello.service';
import { ListapreferitiService } from 'src/app/services/listapreferiti.service';

@Component({
  selector: 'app-musica',
  templateUrl: './musica.component.html',
  styleUrls: ['./musica.component.scss']
})
export class MusicaComponent implements OnInit {

  public musiche:Musica[];
  token!:string | null

  constructor(private musSe: MusicaService, private carSe:CarrelloService, private lisSe:ListapreferitiService) {
    this.musiche=[];
   }

  ngOnInit(): void {
    if(localStorage.getItem("token")){
      this.token=localStorage.getItem("token");
    }
    this.ottieniMusiche();
  }

  public ottieniMusiche(): void {
    this.musSe.ottieniMusiche().subscribe(
      (response: Musica[]) => {
        this.musiche = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public aggiungiAlCarrello(codice: string) {
    this.carSe.aggiungiAlCarrello(codice)
  }

  public aggiungiAllaListaPreferiti(codice: string){
    this.lisSe.aggiungiAllaListaPreferiti(codice)
  }

}
