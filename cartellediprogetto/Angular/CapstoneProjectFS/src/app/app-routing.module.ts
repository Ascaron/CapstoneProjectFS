import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrazioneComponent } from './components/registrazione/registrazione.component';
import { CarrelloComponent } from './components/carrello/carrello.component';
import { ListapreferitiComponent } from './components/listapreferiti/listapreferiti.component';
import { PaginaVideogiochiComponent } from './components/pagina-videogiochi/pagina-videogiochi.component';
import { PaginaFilmTvComponent } from './components/pagina-film-tv/pagina-film-tv.component';
import { PaginaMusicaComponent } from './components/pagina-musica/pagina-musica.component';
import { DatiUtenteComponent } from './components/dati-utente/dati-utente.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [

{
  path:"",
  component:HomeComponent,
},
{
  path:"videogioco",
  component:PaginaVideogiochiComponent,
},
{
  path:"filmtv",
  component:PaginaFilmTvComponent,
},
{
  path:"musica",
  component:PaginaMusicaComponent,
},
{
  path:"login",
  component:LoginComponent,
},
{
  path:"registrazione",
  component:RegistrazioneComponent,
},
{
  path:"carrello",
  component:CarrelloComponent,
  canActivate:[AuthGuard]
},
{
  path:"listapreferiti",
  component:ListapreferitiComponent,
  canActivate:[AuthGuard]
},
{
  path:"datiUtente",
  component:DatiUtenteComponent,
  canActivate:[AuthGuard]
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
