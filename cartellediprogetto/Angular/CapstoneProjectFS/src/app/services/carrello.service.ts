import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError } from 'rxjs';
import { map } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AggiungiAlCarrello, Carrello } from '../interfaces/carrello';
import { Filmtv } from '../interfaces/filmtv';

@Injectable({
  providedIn: 'root'
})
export class CarrelloService{

  private apiServerUrl = environment.apiBaseUrl;
  private aggiungiAlCarrelloString=this.apiServerUrl+'/carrello/aggiungialcarrello';

  constructor(private http: HttpClient) { }

  public ottieniCarrello(): Observable<Carrello> {
    let id=localStorage.getItem("id")
    let token=localStorage.getItem("token")
    return this.http.get<Carrello>(this.apiServerUrl + '/carrello/contenuto/id=' + id, {
      headers:{
        "Authorization": "Bearer "+token
      }
    });

  }

  aggiungiAlCarrello(codiceProdotto: string){
    let id=localStorage.getItem("id")!;
    let token=localStorage.getItem("token");
    let body:AggiungiAlCarrello={
      codice: codiceProdotto,
      idUtente:id
    }
    console.log(body.codice);
    console.log(body.idUtente);
    console.log(this.aggiungiAlCarrelloString+`?id=${id}&codice=${codiceProdotto}`)
    return this.http.post(this.aggiungiAlCarrelloString+`?id=${id}&codice=${codiceProdotto}`, body)
  }

  public ottieniFilmTvNelCarrelloComunicazione(id:number, codice:string): Observable<Filmtv>{
    let token=localStorage.getItem("token");
    return this.http.get<Filmtv>(this.apiServerUrl+`/ottienifilmtvnelcarrelloutente=${id}&codice=${codice}`, {headers:{
      "Authorization": "Bearer "+token
    }})
  }

  public ottieniFilmTvNelCarrello(id:number, codice:string):string|void{
    this.ottieniFilmTvNelCarrelloComunicazione(id, codice).subscribe((res)=>{
      return res.codiceControllo
    })
  }

}
