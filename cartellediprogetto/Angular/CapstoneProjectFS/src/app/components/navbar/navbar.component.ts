import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  token!:string | null

  constructor(private tokenService:TokenService) { }

  ngOnInit(): void {
    if(localStorage.getItem("token")){
      this.token=localStorage.getItem("token");
    }
  }

}
