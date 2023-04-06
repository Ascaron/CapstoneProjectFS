import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError } from 'rxjs';
import { map } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AggiungiAlCarrello, Carrello } from '../interfaces/carrello';
import { Filmtv } from '../interfaces/filmtv';
import { TokenInterceptor } from '../token.interceptor';
import { ProdottoCarrelloAcquistabile } from '../interfaces/prodotto-carrello';

@Injectable({
  providedIn: 'root'
})
export class CarrelloService{

  private apiServerUrl = environment.apiBaseUrl;
  private aggiungiAlCarrelloString=this.apiServerUrl+'/carrello/aggiungialcarrello';

  constructor(private http: HttpClient) { }

  public ottieniCarrello(): Observable<ProdottoCarrelloAcquistabile[]> {
    let id=localStorage.getItem("id")
    return this.http.get<ProdottoCarrelloAcquistabile[]>(this.apiServerUrl + '/carrello/contenuto/id=' + id);

  }

  public ottieniTotaleSpesa(){
    let id=localStorage.getItem("id")
    return this.http.get(this.apiServerUrl+`/carrello/spesatotale?id=${id}`)
  }

  aggiungiAlCarrello(codiceProdotto: string){
    let id=localStorage.getItem("id")!
    let body:AggiungiAlCarrello={
      codice: codiceProdotto,
      idUtente:id
    }
    return this.http.post(this.aggiungiAlCarrelloString+`?id=${id}&codice=${codiceProdotto}`, body)
  }

  public rimuoviDalCarrello(codice:string){
    let id=localStorage.getItem("id")
    return this.http.delete(this.apiServerUrl+`/carrello/rimuovidalcarrello?id=${id}&codice=${codice}`)
  }

}
