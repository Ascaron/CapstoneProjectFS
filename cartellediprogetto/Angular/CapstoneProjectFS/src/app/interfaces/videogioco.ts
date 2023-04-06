export interface Videogioco {
  id: number,
  titolo: string,
  prezzo: string,
  casaSviluppo: string,
  editore: string,
  piattaforma: string,
  codiceControllo: string,
  quantita: string,
  immagine: string
}

export interface VideogiocoCarrelloListaPreferiti {
  id: number,
  titolo: string,
  prezzo: string,
  casaSviluppo: string,
  editore: string,
  piattaforma: string,
  codiceControllo: string,
  quantita: string,
  immagine: string,
  nelCarrello:boolean,
  nellaLista:boolean,
  acquistabile:boolean
}
