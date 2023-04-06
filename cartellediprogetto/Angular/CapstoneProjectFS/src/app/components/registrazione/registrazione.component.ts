import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Registrazione } from 'src/app/interfaces/registrazione';
import { ModificaUtenteService } from 'src/app/services/modifica-utente.service';
import { RegistrazioneService } from 'src/app/services/registrazione.service';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.scss']
})
export class RegistrazioneComponent implements OnInit {

  form!: FormGroup
  interruttore1:boolean
  interruttore2:boolean
  interruttore3:boolean
  listaStringhe:any;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private regSe: RegistrazioneService, private modSe:ModificaUtenteService) {
    this.interruttore1=false;
    this.interruttore2=false;
    this.interruttore3=false;
    this.listaStringhe=[];
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      inputNome: [],
      inputCognome: [],
      inputUsername: [],
      inputEmail: [],
      inputDataNascita: [],
      inputPortafoglio:[],
      inputPassword: [],
      inputCheckPassword: []
    })
  }

  registra() {
    this.modSe.controlloEsistenzaUsername(this.ottieniValoreForm('inputUsername').value, 0).subscribe((res)=>{
      this.listaStringhe=res;
      if(this.listaStringhe.length!=0){
        this.interruttore1=true
      }
      else{
        if(this.ottieniValoreForm('inputPassword').value!=this.ottieniValoreForm('inputCheckPassword').value){
          this.interruttore1=false;
          this.interruttore2=true;
        }
        else{
          if(this.convalidaEmail(this.ottieniValoreForm('inputEmail').value)){
            if (this.form.valid) {
              let data: Registrazione = {
                username: this.ottieniValoreForm('inputUsername').value,
                email: this.ottieniValoreForm('inputEmail').value,
                password: this.ottieniValoreForm('inputPassword').value,
                nome: this.ottieniValoreForm('inputNome').value,
                cognome: this.ottieniValoreForm('inputCognome').value,
                dataNascita:this.ottieniValoreForm('inputDataNascita').value,
                portafoglio:this.ottieniValoreForm('inputPortafoglio').value
              }
              this.regSe.registra(data).subscribe();
              this.router.navigate(['/login']);
            }
          }
          else{
            this.interruttore2=false;
            this.interruttore3=true;
          }
        }
      }
    })
  }

  ottieniValoreForm(valore: string) {
    return this.form.get(valore) as FormControl
  }

  public convalidaEmail(valore:string) {
    var regex_email_valida = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return regex_email_valida.test(valore);
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

}
