import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { PaymentService } from 'src/app/myservies/payment.service';
import { PaymentDataService } from './paymentOps/paymentDataService/payment-data.service';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css','../../app.component.css','../bill/bill.component.css']
})
export class PaymentComponent implements OnInit {

  payments:any = [];
  constructor(private loginService:EmpLoginService,private paymentService:PaymentService,private router:Router,private paymentDataService:PaymentDataService) { }

  ngOnInit(): void {
    this.loginService.isAuthenticate=true;
    this.allPayment();
  }

  //All Payments 
  allPayment(){
    this.paymentService.getAllPayment().subscribe((res:any)=>{
       this.payments= res;
       console.log(res);
    })
  }

  //Get Payment Details
  navigateToPaymentDetails(payment:any){
    this.paymentDataService.setPaymentData(payment)
    this.router.navigate(["payment-details"]);
  }

  //update Payment
  updatePayment(payment:any){
    this.paymentDataService.setPaymentData(payment)
    this.router.navigate(["update-payment"]);
  }

  //Go to Transaction
  addTransaction(payment:any){
   this.paymentDataService.setPaymentData(payment) 
   this.router.navigate(["/add-transaction"]);
  }

}
