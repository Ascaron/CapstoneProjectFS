import { ProdottoCarrello } from "./prodotto-carrello"

export interface Carrello {
  id: number,
  prodottoCarrello:ProdottoCarrello[],
  prezzoTotale: number
}

export interface AggiungiAlCarrello {
codice:string,
idUtente:string
}
