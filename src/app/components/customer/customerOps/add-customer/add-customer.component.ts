import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
 
import { EmpLoginService } from 'src/app/emp-login.service';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/myservies/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  
  constructor(private customerService :CustomerService,private router:Router,private authLogin:EmpLoginService) { }
  
  customer:any = <Customer>{}
  errorMessage:string='';
  isError:boolean=true;

  ngOnInit(): void {
    this.authLogin.isAuthenticate=true;
  }


  onSubmit(formData:any){
    
      this.customer ={
        customerId: formData.value.customerId,
        customerName: formData.value.customerName,
        password: formData.value.password,
        customerAadharcardno:formData.value.customerAadharcardno,
        otp:formData.value.otp,
        address: {
            street:formData.value.street,
             city:formData.value.city,
             state:formData.value.state,
             postalCode:formData.value.postalCode,
        },
        contactInfo: {
            email:formData.value.email,
           phone:formData.value.phone,
        }
      }
      this.customerService.addCustomer(this.customer).subscribe((res:any)=>{
      //  if(res != null){
       
      //  }
      console.log(res);

      }),(error:any)=>{
        this.errorMessage=error.error;
        this.router.navigate(["/customer"]);
      }
    }

  }
 


