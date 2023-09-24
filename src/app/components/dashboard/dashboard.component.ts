import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private loginService:EmpLoginService,private router:Router) { }

  ngOnInit(): void {
    this.loginService.isAuthenticate=true;
    
  }
  

}
