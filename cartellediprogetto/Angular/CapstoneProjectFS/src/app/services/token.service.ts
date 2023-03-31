import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  recuperaToken() {
   return localStorage.getItem("token");
  }

  recuperaUtenteLoggato() {
    return localStorage.getItem("id");
  }

  recuperaRuoliUtente() {
    return localStorage.getItem("ruolo1");
  }

}
