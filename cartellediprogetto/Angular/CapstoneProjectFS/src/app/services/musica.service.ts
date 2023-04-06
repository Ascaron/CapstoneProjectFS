import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Musica, MusicaCarrelloListaPreferiti } from '../interfaces/musica';

@Injectable({
  providedIn: 'root'
})
export class MusicaService {

  private apiServerUrl = environment.apiBaseUrl;
  private ottieniMusicheString = this.apiServerUrl+ '/musiche/tutte';

  constructor(private http: HttpClient) { }

  public ottieniMusiche():  Observable<Musica[]>{
    return this.http.get<Musica[]>(this.ottieniMusicheString);
  };

  public ottieniMusicaCarrelloLista(id:number): Observable<MusicaCarrelloListaPreferiti[]>{
    return this.http.get<MusicaCarrelloListaPreferiti[]>(this.apiServerUrl+`/musiche/controllointeressantimusica/id=${id}`)
  }

}
