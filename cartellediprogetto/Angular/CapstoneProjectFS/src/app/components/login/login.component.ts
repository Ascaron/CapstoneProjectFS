import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { Loginrequest } from 'src/app/interfaces/loginrequest';
import { ModificaUtenteService } from 'src/app/services/modifica-utente.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form!: FormGroup
  interruttore1:boolean
  interruttore2:boolean
  interruttore3:boolean
  listaStringhe1:any;
  listaStringhe2:any;

  constructor(private formBuilder: FormBuilder, private loginService:LoginService, private router:Router, private modSe:ModificaUtenteService) {
    this.interruttore1=false;
    this.interruttore2=false;
    this.interruttore3=false;
    this.listaStringhe1=[];
    this.listaStringhe2=[];
   }

  ngOnInit(): void {
    this.form=this.formBuilder.group({
      inputUsername:[],
      inputPassword:[]
    })
  }

  login(){
    this.modSe.controlloEsistenzaUsername(this.ottieniValoreForm('inputUsername').value, 0).subscribe((res)=>{
      this.listaStringhe1=res;
      if(this.listaStringhe1.length==0){
        this.interruttore1=true;
      }
      else{
        this.loginService.controlloCorrispondenzaPassword(this.ottieniValoreForm('inputUsername').value,
        this.ottieniValoreForm('inputPassword').value).subscribe((res)=>{
          this.listaStringhe2=res;
          if(this.listaStringhe2.length==0){
            this.interruttore1=false;
            this.interruttore2=true;
          }
          else{
            if (this.form.valid){
              let data:Loginrequest={
                username:this.ottieniValoreForm('inputUsername').value,
                password:this.ottieniValoreForm('inputPassword').value
              }
              this.loginService.login(data).subscribe(res=>{
                this.router.navigate([''])
              })
            }
          }
        })
      }
    })
  }

  ottieniValoreForm(valore: string) {
    return this.form.get(valore) as FormControl
  }

  public occhio(){
    document.querySelectorAll(".occhio").forEach((el)=>{
      el.classList.toggle("fa-eye")
      el.classList.toggle("fa-eye-slash")
    })
  }

}
