import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Videogioco, VideogiocoCarrelloListaPreferiti } from '../interfaces/videogioco';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VideogiocoService {

  private apiServerUrl = environment.apiBaseUrl;
  private ottieniVideogiochiString = this.apiServerUrl+ '/videogiochi/tutti';

  constructor(private http: HttpClient) { }

  public ottieniVideogiochi():  Observable<Videogioco[]>{
    return this.http.get<Videogioco[]>(this.ottieniVideogiochiString);
  };

  public ottieniVideogiocoCarrelloListaPreferiti(id:number): Observable<VideogiocoCarrelloListaPreferiti[]>{
    return this.http.get<VideogiocoCarrelloListaPreferiti[]>(this.apiServerUrl+`/videogiochi/controllointeressantivideogiochi/id=${id}`)
  }

}
