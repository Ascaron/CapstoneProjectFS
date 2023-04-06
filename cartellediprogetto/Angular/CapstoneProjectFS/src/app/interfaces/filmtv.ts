export interface Filmtv {
  id:number,
  titolo:string,
  prezzo:string,
  durata:string,
  regista:string,
  attori:string,
  casaProduzione:string,
  formato:string,
  codiceControllo:string,
  quantita:string,
  immagine:string
}

export interface FilmTvCarrelloListaPreferiti {
  id:number,
  titolo:string,
  prezzo:string,
  durata:string,
  regista:string,
  attori:string,
  casaProduzione:string,
  formato:string,
  codiceControllo:string,
  quantita:string,
  immagine:string,
  nelCarrello:boolean,
  nellaLista:boolean,
  acquistabile:boolean
}
