import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Carrello } from 'src/app/interfaces/carrello';
import { CarrelloService } from 'src/app/services/carrello.service';
import { LoginService } from 'src/app/services/login.service';
import { Loginresponse } from 'src/app/interfaces/loginresponse';
import { ProdottoCarrello } from 'src/app/interfaces/prodotto-carrello';

@Component({
  selector: 'app-carrello',
  templateUrl: './carrello.component.html',
  styleUrls: ['./carrello.component.scss']
})
export class CarrelloComponent implements OnInit {

  public carrelloProdotti: ProdottoCarrello[];

  constructor(private carSe:CarrelloService, private logSe:LoginService) {
    this.carrelloProdotti=[];
  }

  ngOnInit(): void {
    this.ottieniCarrello();
  }

  public ottieniCarrello(): void {
    this.carSe.ottieniCarrello().subscribe(
      (response: Carrello) => {
        this.carrelloProdotti = response.prodottoCarrello;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
