import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Videogioco } from 'src/app/interfaces/videogioco';
import { VideogiocoService } from 'src/app/services/videogioco.service';
import { CarrelloService } from 'src/app/services/carrello.service';
import { ListapreferitiService } from 'src/app/services/listapreferiti.service';

@Component({
  selector: 'app-videogioco',
  templateUrl: './videogioco.component.html',
  styleUrls: ['./videogioco.component.scss']
})
export class VideogiocoComponent implements OnInit {

  public videogiochi: Videogioco[];
  token!:string | null

  constructor(private videogiocoService: VideogiocoService, private carSe:CarrelloService, private lisSe:ListapreferitiService) {
    this.videogiochi = [];
  }

  ngOnInit(): void {
    if(localStorage.getItem("token")){
      this.token=localStorage.getItem("token");
    }
    this.ottieniVideogiochi();
  }

  public ottieniVideogiochi(): void {
    this.videogiocoService.ottieniVideogiochi().subscribe(
      (response: Videogioco[]) => {
        this.videogiochi = response;
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
