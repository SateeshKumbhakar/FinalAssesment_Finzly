import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EmpLoginService } from '../emp-login.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  numberPattern = "^[0-9]+$";
  loginFailedMsg: string = "";
  requestBody: any = {}
  data: string = "";



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
        alert(response.errorMsg);
        this.router.navigate(["/home"]);
      }

    }), (error: HttpErrorResponse) => {
      if (error instanceof SyntaxError) {
        console.log(" Sateesh" + error)
      } else {
        console.log("saafgasa" + error.error);
      }
    };
    console.log(this.requestBody);
    console.log(this.data);
    //  loginForm.reset();
  }

}
