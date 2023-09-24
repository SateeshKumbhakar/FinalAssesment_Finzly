import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  constructor(private loginServie:EmpLoginService) { }

  ngOnInit(): void {
    this.loginServie.isAuthenticate=true;
  }

}
