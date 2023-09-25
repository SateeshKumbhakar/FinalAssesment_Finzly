import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';

@Component({
  selector: 'app-bill-details',
  templateUrl: './bill-details.component.html',
  styleUrls: ['./bill-details.component.css']
})
export class BillDetailsComponent implements OnInit {

  constructor(private route:ActivatedRoute,private authService:EmpLoginService) { }

  ngOnInit(): void {
    this.authService.isAuthenticate=true;
  }

 
}
