import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Registrazione } from 'src/app/interfaces/registrazione';
import { RegistrazioneService } from 'src/app/services/registrazione.service';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.scss']
})
export class RegistrazioneComponent implements OnInit {

  form!: FormGroup

  constructor(private formBuilder: FormBuilder, private router: Router, private regSe: RegistrazioneService) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      inputNome: [],
      inputCognome: [],
      inputUsername: [],
      inputEmail: [],
      inputDataNascita: [],
      inputPortafoglio:[],
      inputPassword: []
    })
  }

  registra() {
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

  ottieniValoreForm(valore: string) {
    return this.form.get(valore) as FormControl
  }

}
