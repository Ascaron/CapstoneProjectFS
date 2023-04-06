import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { UtenteService } from 'src/app/services/utente.service';
import { Registrazione } from 'src/app/interfaces/registrazione';
import { RecordAcquisti } from 'src/app/interfaces/record-acquisti';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { ModificaUtenteService } from 'src/app/services/modifica-utente.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-dati-utente',
  templateUrl: './dati-utente.component.html',
  styleUrls: ['./dati-utente.component.scss']
})
export class DatiUtenteComponent implements OnInit {

  public utenti:Registrazione[];
  public recordAcquisti:RecordAcquisti[];
  form1!: FormGroup
  form2!: FormGroup
  interruttore1:boolean
  interruttore2:boolean
  interruttore3:boolean
  listaStringhe:any;
  idUtente!: number;

  constructor(private uteSe:UtenteService, private formBuilder: FormBuilder, private modSe:ModificaUtenteService, private logSe:LoginService) {
    this.utenti=[];
    this.recordAcquisti=[];
    this.interruttore1=false;
    this.interruttore2=false;
    this.interruttore3=false;
    this.listaStringhe=[];
  }

  ngOnInit(): void {
    this.idUtente = parseInt(localStorage.getItem("id")!);
    this.ottieniUtente();
    this.ottieniRecordAcquisti();
    this.form1 = this.formBuilder.group({
      inputNome: [],
      inputCognome: [],
      inputUsername: [],
      inputEmail: [],
      inputDataNascita: [],
      inputPortafoglio:0,
      inputPassword: [],
      inputCheckPassword: []
    })
    this.form2=this.formBuilder.group({
      ricaricaSoloPortafoglio:0
    })
  }

  public ottieniUtente(){
    this.uteSe.ottieniUtente().subscribe((res)=>{
      this.utenti=res
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    })
  }

  public ottieniRecordAcquisti(){
    this.uteSe.ottieniReportAcquisti().subscribe((res)=>{
      this.recordAcquisti=res;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    })
  }

  public cambia(){
     document.querySelectorAll(".datiOriginali, .nuoviDati").forEach((el)=>{
      el.classList.toggle("rimuoviForm")
     })
  }

  public occhio1(){
    document.querySelectorAll(".occhio1").forEach((el)=>{
      el.classList.toggle("fa-eye")
      el.classList.toggle("fa-eye-slash")
    })
  }

  public occhio2(){
    document.querySelectorAll(".occhio2").forEach((el)=>{
      el.classList.toggle("fa-eye")
      el.classList.toggle("fa-eye-slash")
    })
  }

  public occhio3(){
    document.querySelectorAll(".occhio3").forEach((el)=>{
      el.classList.toggle("fa-eye")
      el.classList.toggle("fa-eye-slash")
    })
  }

  public invia1(){
    this.modSe.controlloEsistenzaUsername(this.ottieniValoreForm1('inputUsername').value, this.idUtente).subscribe((res)=>{
      this.listaStringhe=res;
      if(this.listaStringhe.length!=0){
        this.interruttore1=true;
        this.interruttore2=false;
        this.interruttore3=false;
      }
      else{
        if(this.ottieniValoreForm1('inputPassword').value!=this.ottieniValoreForm1('inputCheckPassword').value){
          this.interruttore1=false;
          this.interruttore2=true;
          this.interruttore3=false;
        }
        else{
          if(this.convalidaEmail(this.ottieniValoreForm1('inputEmail').value)){
            if (this.form1.valid) {
              let data: Registrazione = {
                username: this.ottieniValoreForm1('inputUsername').value,
                email: this.ottieniValoreForm1('inputEmail').value,
                password: this.ottieniValoreForm1('inputPassword').value,
                nome: this.ottieniValoreForm1('inputNome').value,
                cognome: this.ottieniValoreForm1('inputCognome').value,
                dataNascita:this.ottieniValoreForm1('inputDataNascita').value,
                portafoglio:this.ottieniValoreForm1('inputPortafoglio').value
              }
              this.modSe.modificaUtente(data).subscribe();
              this.logSe.logout()

              document.querySelectorAll(".utenteDaModificare, .utenteModificato").forEach((el)=>{
                el.classList.toggle("scompari")
              })
            }
          }
          else{
            this.interruttore1=false;
            this.interruttore2=false;
            this.interruttore3=true;
          }
        }
      }
    })
  }

  public invia2(){
    let data: Registrazione = {
      username: this.utenti[0].username,
      email: this.utenti[0].email,
      password: this.utenti[0].password,
      nome: this.utenti[0].nome,
      cognome: this.utenti[0].cognome,
      dataNascita:this.utenti[0].dataNascita,
      portafoglio:this.ottieniValoreForm2('ricaricaSoloPortafoglio').value
    }
    this.modSe.modificaUtente(data).subscribe();
    document.querySelectorAll(".utenteDaModificare, .ricaricaEffettuata").forEach((el)=>{
      el.classList.toggle("scompari")
    })
  }

  ottieniValoreForm1(valore: string) {
    return this.form1.get(valore) as FormControl
  }

  ottieniValoreForm2(valore: string) {
    return this.form2.get(valore) as FormControl
  }

  public convalidaEmail(valore:string) {
    var regex_email_valida = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return regex_email_valida.test(valore);
  }

}
