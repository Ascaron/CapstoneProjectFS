import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Carrello } from 'src/app/interfaces/carrello';
import { CarrelloService } from 'src/app/services/carrello.service';
import { LoginService } from 'src/app/services/login.service';
import { Loginresponse } from 'src/app/interfaces/loginresponse';
import { ProdottoCarrello, ProdottoCarrelloAcquistabile } from 'src/app/interfaces/prodotto-carrello';
import { AcquistoService } from 'src/app/services/acquisto.service';

@Component({
  selector: 'app-carrello',
  templateUrl: './carrello.component.html',
  styleUrls: ['./carrello.component.scss']
})
export class CarrelloComponent implements OnInit {

  public carrelloProdotti: ProdottoCarrelloAcquistabile[];
  listaStringhe:any;
  listaProdotti: ProdottoCarrelloAcquistabile[];
  interruttore1:boolean;
  interruttore2:boolean;
  listaNumeri:any

  constructor(private carSe:CarrelloService, private acqSe:AcquistoService) {
    this.carrelloProdotti=[];
    this.listaStringhe=[];
    this.listaProdotti=[];
    this.interruttore1=true;
    this.interruttore2=true;
    this.listaNumeri=[];
  }

  ngOnInit(): void {
    this.ottieniCarrello();
    this.carSe.ottieniCarrello().subscribe((resp)=>{
      this.listaProdotti=resp;
      if(this.listaProdotti.length==0){
        this.interruttore1=false;
      }
    })
    this.acqSe.controlloAcquisto().subscribe((res)=>{
      this.listaStringhe=res;
      if(this.listaStringhe.length>0){
        this.interruttore2=false;
      }
    })
    this.ottieniTotaleSpesa()
  }

  public ottieniCarrello(): void {
    this.carSe.ottieniCarrello().subscribe(
      (response: ProdottoCarrelloAcquistabile[]) => {
        this.carrelloProdotti = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public ottieniTotaleSpesa(){
    this.carSe.ottieniTotaleSpesa().subscribe((res)=>{
      this.listaNumeri=res
    })
  }

  public aggiungiAlCarrello(codice:string){
    this.carSe.aggiungiAlCarrello(codice).subscribe()
  }

  public rimuoviDalCarrello(codice:string){
    this.carSe.rimuoviDalCarrello(codice).subscribe()
  }

  public acquista(){
    this.acqSe.acquisto().subscribe()

    document.querySelectorAll(".acquistoInCorso, .acquistoConcluso").forEach((el)=>{
      el.classList.toggle("scompari")
    })
  }

  public ricaricaPagina(){
    window.location.reload();
  }

}
