import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/myservies/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  
  //Store all customer
  customerData:any=<Customer>{}

  constructor(private loginService:EmpLoginService) { }

  ngOnInit(): void {
    this.loginService.isAuthenticate=true;
     
  }
  
  // getAllCustomer(){
  //   this.customerService.getAllCustomer().subscribe((res:any)=>{
  //   this.customerData =res;
  //   console.log( "parent"+ res); 
  //   })
  // }

}
