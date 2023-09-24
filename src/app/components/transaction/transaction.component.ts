import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  constructor(private loginService:EmpLoginService) { }

  ngOnInit(): void {
    this.loginService.isAuthenticate=true;
  }

}
