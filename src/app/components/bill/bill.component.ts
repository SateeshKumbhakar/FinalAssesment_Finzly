import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';
import { BillService } from 'src/app/myservies/bill.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

  constructor(private billService:BillService,private loginServie:EmpLoginService) { }

  ngOnInit(): void {
    this.loginServie.isAuthenticate = true;
  }

  
  
}
