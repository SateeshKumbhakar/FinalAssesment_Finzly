import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EmpLoginService } from '../emp-login.service';

import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  numberPattern = "^[0-9]+$";
 
  requestBody: any = {}
  interalErrorMessage:string="";
  isLoggedIn = true;

  constructor(private loginService: EmpLoginService, private router: Router) { }
  
  ngOnInit(): void {
  }

  onSubmit(loginForm: NgForm) {

    this.requestBody = {
      employeeId: loginForm.value.employeeId,
      otp: loginForm.value.otp,
      password: loginForm.value.password
    }

    this.loginService.login(this.requestBody).subscribe((response: any) => {

      if (response.token != null) {
        console.log(response.token)
        sessionStorage.setItem("token", response.token);
        this.loginService.isAuthenticate = true;
        this.router.navigate(["/dashboard"]);
      }

      else {
        this.loginService.isAuthenticate = false;
        sessionStorage.removeItem(response.token);
        // alert(response.errorMsg);
        // this.router.navigate(["/home"]);
        this.isLoggedIn=false;
        this.interalErrorMessage = response.errorMsg;
        console.log(this.interalErrorMessage);
      }

    }),(error:any)=>{
      console.log(error.error);
      // this.isLoggedIn=false;
      // this.interalErrorMessage =error.error;
    }  
    };
   
  }
