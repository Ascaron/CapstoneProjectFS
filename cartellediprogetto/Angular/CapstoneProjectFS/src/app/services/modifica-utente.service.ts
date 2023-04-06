import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError } from 'rxjs';
import { map } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Registrazione } from '../interfaces/registrazione';

@Injectable({
  providedIn: 'root'
})
export class ModificaUtenteService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public modificaUtente(utente:Registrazione){
    let idUtente=localStorage.getItem("id");
    return this.http.put(this.apiServerUrl+`/modifica/modificautente?id=${idUtente}`, utente)
  }

  public controlloEsistenzaUsername(username:string, id:number){
    return this.http.get(this.apiServerUrl+`/modifica/controlloesistenzausername?username=${username}&id=${id}`)
  }

}
