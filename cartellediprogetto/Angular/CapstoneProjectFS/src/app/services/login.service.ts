import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, tap, ReplaySubject, Subject, BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Loginresponse } from '../interfaces/loginresponse';
import { Loginrequest } from '../interfaces/loginrequest';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private authSubj = new BehaviorSubject<null | Loginresponse>(null);
  user$ = this.authSubj.asObservable();
  loggedSubj = new ReplaySubject<false | Loginresponse>();
  private apiServerUrl = environment.apiBaseUrl;
  private ottieniLoginString = this.apiServerUrl + '/aut/login';

  constructor(private http: HttpClient) { }

  login(data: Loginrequest) {
    return this.http.post<Loginresponse>(this.ottieniLoginString, data).pipe(catchError(err => {
      console.log(err);
      throw err;
    }), tap((res) => {
      localStorage.setItem("token", res.token);
      localStorage.setItem("email", res.email);
      localStorage.setItem("nome", res.username);
      localStorage.setItem("id", res.id.toString());
      localStorage.setItem("ruolo1", res.roles[0]);
      if (res.roles.length == 2) {
        localStorage.setItem("ruolo2", res.roles[1])
      }
      this.loggedSubj.next(res)
    }))
  }

  ottieniLoggato(){
    return this.loggedSubj.asObservable()
  }

}
