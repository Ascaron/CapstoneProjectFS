import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError } from 'rxjs';
import { map } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CarrelloService } from './carrello.service';

@Injectable({
  providedIn: 'root'
})
export class AcquistoService {

  idCarrello!:number;

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient, private carSe:CarrelloService) { }

  public acquisto(){
    let idUtente=localStorage.getItem("id")
    let oggi=new Date();
    let giorno=this.generaData(oggi);
    let mese= this.generaMese(oggi);
    let anno=oggi.getFullYear();
    let stringa= `${anno}-${mese}-${giorno}`
    let body={
      idUt:idUtente,
      data:stringa
    }
    return this.http.post(this.apiServerUrl+`/acquisto/effettuaacquisto?idUtente=${body.idUt}&data=${body.data}`, body)
  }

  public controlloAcquisto(){
    let idUtente=localStorage.getItem("id")
    return this.http.get(this.apiServerUrl+`/acquisto/controlloacquisto?idUtente=${idUtente}`)
  }

  public generaData(oggi:Date){
    if(oggi.getDate()<10){
      return `0${oggi.getDate()}`
    }
    return `${oggi.getDate()}`;
  }

  public generaMese(oggi:Date){
    if((oggi.getMonth()+1)<10){
      return `0${oggi.getMonth()+1}`
    }
    return `${oggi.getMonth()+1}`
  }

}
