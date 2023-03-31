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
  private aggiungiAllaListaPreferitiString = this.apiServerUrl+'/aggiungi';

  constructor(private http: HttpClient) { }

  public ottieniListapreferiti():  Observable<Listapreferiti>{
    let id=localStorage.getItem("id")
    return this.http.get<Listapreferiti>(this.apiServerUrl+ '/listapreferiti/contenuto/id='+id);

  };

  public aggiungiAllaListaPreferiti(codiceProdotto:string){
    let id=localStorage.getItem("id")!;
    let token=localStorage.getItem("token");
    var data:AggiungiAlCarrello={
      codice: codiceProdotto,
      idUtente:id
    }
    console.log(data.codice);
    console.log(data.idUtente);
    return this.http.post(this.aggiungiAllaListaPreferitiString, data)
    .pipe(catchError(err=>{
      console.log(err);
      throw err;
    }))
  }

}
