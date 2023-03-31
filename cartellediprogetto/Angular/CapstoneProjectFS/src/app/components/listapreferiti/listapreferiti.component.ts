import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Listapreferiti } from 'src/app/interfaces/listapreferiti';
import { ListapreferitiService } from 'src/app/services/listapreferiti.service';
import { ProdottoListaPreferiti } from 'src/app/interfaces/prodotto-lista-preferiti';

@Component({
  selector: 'app-listapreferiti',
  templateUrl: './listapreferiti.component.html',
  styleUrls: ['./listapreferiti.component.scss']
})
export class ListapreferitiComponent implements OnInit {

  public listaPreferitiProdotti: ProdottoListaPreferiti[];

  constructor(private lisSe:ListapreferitiService) {
    this.listaPreferitiProdotti=[];
  }

  ngOnInit(): void {
    this.ottieniListaPreferiti();
  }

  public ottieniListaPreferiti(): void {
    this.lisSe.ottieniListapreferiti().subscribe(
      (response: Listapreferiti) => {
        this.listaPreferitiProdotti = response.prodottoListaPreferiti;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
