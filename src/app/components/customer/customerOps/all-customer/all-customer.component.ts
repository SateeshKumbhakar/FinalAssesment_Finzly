import { Component, Input, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';
import { CustomerService } from 'src/app/myservies/customer.service';

@Component({
  selector: 'app-all-customer',
  templateUrl: './all-customer.component.html',
  styleUrls: ['./all-customer.component.css']
})
export class AllCustomerComponent implements OnInit {

  // @Input() customers :any[]=[];
  
  //  customers :any[]=[];
  constructor(private customerService:CustomerService,private loginService:EmpLoginService) { }
  customers :any[]=[];
  ngOnInit(): void {
    this.loginService.isAuthenticate=true;
    this.showCustomer();
   
  }

  showCustomer(){
     this.customerService.getAllCustomer().subscribe((res:any)=>{
      console.log(res);
      this.customers=res;
     console.log(this.customers);
     });
  }

  

}
