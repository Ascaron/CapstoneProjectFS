export interface Musica {
  id:number,
  titolo:string,
  prezzo:string,
  autore:string,
  editore:string,
  formatoDisco:string,
  codiceControllo:string,
  quantita:string,
  immagine:string
}

export interface MusicaCarrelloListaPreferiti {
  id:number,
  titolo:string,
  prezzo:string,
  autore:string,
  editore:string,
  formatoDisco:string,
  codiceControllo:string,
  quantita:string,
  immagine:string,
  nelCarrello:boolean,
  nellaLista:boolean,
  acquistabile:boolean
}
