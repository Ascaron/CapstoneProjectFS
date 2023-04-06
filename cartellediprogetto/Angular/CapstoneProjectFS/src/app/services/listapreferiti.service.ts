import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Listapreferiti } from '../interfaces/listapreferiti';
import { AggiungiAlCarrello } from '../interfaces/carrello';

@Injectable({
  providedIn: 'root'
})
export class ListapreferitiService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public ottieniListapreferiti():  Observable<Listapreferiti>{
    let id=localStorage.getItem("id")
    return this.http.get<Listapreferiti>(this.apiServerUrl+ '/listapreferiti/contenuto/id='+id);
  };

  public aggiungiAllaListaPreferiti(codiceProdotto:string){
    let id=localStorage.getItem("id")!;
    let data:AggiungiAlCarrello={
      codice: codiceProdotto,
      idUtente:id
    }
    return this.http.post(this.apiServerUrl+`/listapreferiti/aggiungiallalistapreferiti?id=${data.idUtente}&codice=${data.codice}`, data)
    .pipe(catchError(err=>{
      console.log(err);
      throw err;
    }))
  }

  public rimuoviDallaListaPreferiti(codiceProdotto:string){
    let idUtente=localStorage.getItem("id")!;
    return this.http.delete(this.apiServerUrl+`/listapreferiti/rimuovidallalistapreferiti?id=${idUtente}&codice=${codiceProdotto}`)
  }

}
