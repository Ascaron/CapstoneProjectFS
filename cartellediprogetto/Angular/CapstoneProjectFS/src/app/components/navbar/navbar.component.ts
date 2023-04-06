import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  token!:string | null

  constructor(private logSe:LoginService, private router: Router) { }

  ngOnInit(): void {
    if(localStorage.getItem("token")){
      this.token=localStorage.getItem("token");
    }
  }

  public ricaricaPagina(){
    window.location.reload();
  }

  public logout(){
    this.logSe.logout()
    this.router.navigate(['/login']);
  }

}
