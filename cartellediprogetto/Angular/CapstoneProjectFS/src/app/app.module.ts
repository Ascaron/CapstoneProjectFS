import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VideogiocoComponent } from './components/videogioco/videogioco.component';
import { HomeComponent } from './components/home/home.component';
import { VideogiocoService } from './services/videogioco.service';
import { LoginComponent } from './components/login/login.component';
import { RegistrazioneComponent } from './components/registrazione/registrazione.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FilmtvComponent } from './components/filmtv/filmtv.component';
import { MusicaComponent } from './components/musica/musica.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CarrelloComponent } from './components/carrello/carrello.component';
import { ListapreferitiComponent } from './components/listapreferiti/listapreferiti.component';
import { TuttiprodottiComponent } from './components/tuttiprodotti/tuttiprodotti.component';
import { PaginaVideogiochiComponent } from './components/pagina-videogiochi/pagina-videogiochi.component';
import { PaginaFilmTvComponent } from './components/pagina-film-tv/pagina-film-tv.component';
import { PaginaMusicaComponent } from './components/pagina-musica/pagina-musica.component';
import { TokenInterceptor } from './token.interceptor';
import { DatiUtenteComponent } from './components/dati-utente/dati-utente.component';

@NgModule({
  declarations: [
    AppComponent,
    VideogiocoComponent,
    HomeComponent,
    LoginComponent,
    RegistrazioneComponent,
    NavbarComponent,
    FilmtvComponent,
    MusicaComponent,
    CarrelloComponent,
    ListapreferitiComponent,
    TuttiprodottiComponent,
    PaginaVideogiochiComponent,
    PaginaFilmTvComponent,
    PaginaMusicaComponent,
    DatiUtenteComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass:TokenInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
