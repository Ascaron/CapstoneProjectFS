import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Registrazione } from '../interfaces/registrazione';
import { RecordAcquisti } from '../interfaces/record-acquisti';

@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public ottieniUtente():Observable<Registrazione[]>{
    let id=localStorage.getItem("id")
    return this.http.get<Registrazione[]>(this.apiServerUrl+`/utente/ottieniutente?id=${id}`)
  }

  public ottieniReportAcquisti():Observable<RecordAcquisti[]>{
    let id=localStorage.getItem("id")
    return this.http.get<RecordAcquisti[]>(this.apiServerUrl+`/utente/ottienirecordacquisti?id=${id}`)
  }

}
