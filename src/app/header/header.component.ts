import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from '../emp-login.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

 
  constructor(private loginService:EmpLoginService,private router:Router) { }

  ngOnInit(): void {
    
  }
  isLoggedIn():boolean{
   return this.loginService.isAuthenticate;
  }
  
  logout(){
    this.loginService.isAuthenticate=false;
    sessionStorage.removeItem("token");
    this.router.navigate(["/home"]);

  }
  
}
