import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable, switchMap, take } from 'rxjs';
import { LoginService } from './services/login.service';
import { CarrelloService } from './services/carrello.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private logSe:LoginService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return this.logSe.user$.pipe(take(1),switchMap(user=>{
      if (!user) {
        console.log("MARIO")
        return next.handle(req)

      }
      const newReq = req.clone({
        headers:req.headers.set('Authorization',`Bearer ${user.token}`)
      })
      console.log("PINA")
      return next.handle(newReq)
    }));
  }
}
