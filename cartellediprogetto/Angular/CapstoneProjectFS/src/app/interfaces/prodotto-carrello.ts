export interface ProdottoCarrello {
  id:number,
	titolo:string,
	prezzo:number,
	codiceControllo:string,
	quantita:number,
	immagine:string
}

export interface ProdottoCarrelloAcquistabile{
  id:number,
	titolo:string,
	prezzo:number,
	codiceControllo:string,
	quantita:number,
	immagine:string,
  acquistabile:boolean
}
