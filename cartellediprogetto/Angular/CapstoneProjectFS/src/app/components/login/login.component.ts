import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { Loginrequest } from 'src/app/interfaces/loginrequest';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form!: FormGroup

  constructor(private formBuilder: FormBuilder, private loginService:LoginService, private router:Router) { }

  ngOnInit(): void {
    this.form=this.formBuilder.group({
      inputUsername:[],
      inputPassword:[]
    })
  }

  login(){
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

  ottieniValoreForm(valore: string) {
    return this.form.get(valore) as FormControl
  }

}
