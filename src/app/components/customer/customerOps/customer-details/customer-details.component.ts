import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/myservies/customer.service';



@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css','../../../dashboard/dashboard.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute,private customerService:CustomerService,private authService:EmpLoginService) { }
  customerId !: number;
  customer:any= <Customer>{};

  ngOnInit(): void {
    this.authService.isAuthenticate=true;
    this.route.paramMap.subscribe((params:any) => {
      
       this.customerId =+ params.get('id');  
      //  console.log("details" + this.customerId) ;
      this.getCustomer(this.customerId);
    });
  }

  getCustomer(customerId:number){
    this.customerService.getCustomer(customerId).subscribe((res:any)=>{
      // console.log(res);
      this.customer= res;
    });
  }



}
