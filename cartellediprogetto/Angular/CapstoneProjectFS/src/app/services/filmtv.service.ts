import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Filmtv } from '../interfaces/filmtv';

@Injectable({
  providedIn: 'root'
})
export class FilmtvService {

  private apiServerUrl = environment.apiBaseUrl;
  private ottieniFilmtvString = this.apiServerUrl+ '/filmtv/tutti';

  constructor(private http: HttpClient) { }

  public ottieniFilmtv():  Observable<Filmtv[]>{
    return this.http.get<Filmtv[]>(this.ottieniFilmtvString);
  };

}
