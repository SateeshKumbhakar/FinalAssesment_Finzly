import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor(private loginService:EmpLoginService) { }

  ngOnInit(): void {
    this.loginService.isAuthenticate=true;
  }

}
