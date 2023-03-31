import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError} from 'rxjs';
import { environment } from 'src/environments/environment';
import { Registrazione } from '../interfaces/registrazione';

@Injectable({
  providedIn: 'root'
})
export class RegistrazioneService {

  private apiServerUrl = environment.apiBaseUrl;
  private ottieniRegistrazioneString = this.apiServerUrl+ '/registrazione/registrautente';

  constructor(private http: HttpClient) { }

  registra(data:Registrazione){
    return this.http.post(this.ottieniRegistrazioneString, data).pipe(catchError(err=>{
      console.log(err);
      throw err;
    }))
  }

}
