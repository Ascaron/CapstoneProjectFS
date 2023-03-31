import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { VideogiocoComponent } from './components/videogioco/videogioco.component';
import { FilmtvComponent } from './components/filmtv/filmtv.component';
import { MusicaComponent } from './components/musica/musica.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrazioneComponent } from './components/registrazione/registrazione.component';
import { CarrelloComponent } from './components/carrello/carrello.component';
import { ListapreferitiComponent } from './components/listapreferiti/listapreferiti.component';

const routes: Routes = [

{
  path:"",
  component:HomeComponent,
},
{
  path:"videogioco",
  component:VideogiocoComponent,
},
{
  path:"filmtv",
  component:FilmtvComponent,
},
{
  path:"musica",
  component:MusicaComponent,
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
},
{
  path:"listapreferiti",
  component:ListapreferitiComponent,
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
