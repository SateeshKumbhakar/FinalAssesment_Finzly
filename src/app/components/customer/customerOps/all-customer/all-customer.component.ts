import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { CustomerService } from 'src/app/myservies/customer.service';


@Component({
  selector: 'app-all-customer',
  templateUrl: './all-customer.component.html',
  styleUrls: ['./all-customer.component.css','../../../../app.component.css']
})
export class AllCustomerComponent implements OnInit {

  // @Input() customers :any[]=[];
  
  //  customers :any[]=[];
  constructor(private customerService:CustomerService,private loginService:EmpLoginService,private router:Router) { }
  customers :any[]=[];
  ngOnInit(): void {
    this.loginService.isAuthenticate=true;
    this.showCustomer();
   
  }

  showCustomer(){
     this.customerService.getAllCustomer().subscribe((res:any)=>{
      this.customers=res;
     });
  }

  navigateToCustomerDetails(customerId:number){
    this.router.navigate(['/customer-details', customerId]);
  }
  
  navigateToDeleteCustomer(customerId:number){

  }
  navigateToUpdateCustomer(customerId:number){


  }
 


}
