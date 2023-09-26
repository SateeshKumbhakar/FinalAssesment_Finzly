import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Payment } from 'src/app/model/payment';
import { PaymentService } from 'src/app/myservies/payment.service';

@Component({
  selector: 'app-add-payment',
  templateUrl: './add-payment.component.html',
  styleUrls: ['./add-payment.component.css']
})
export class AddPaymentComponent implements OnInit {

  paymentModeOptions=["Online","Cash"];
  paymentMethodOptions=["Credit Card","Debit Card","Wallet"];
  customerId:any;
  billId:any;
  errorMessage:any;
  isError=false;
  paymentData:any=<Payment>{};

  constructor( private route: ActivatedRoute, private authService:EmpLoginService,private paymentService:PaymentService,private router: Router) { }

  ngOnInit(): void {
    this.authService.isAuthenticate= true;
    this.route.paramMap.subscribe((param)=>{
    this.customerId = param.get('customerId');
    this.billId = param.get('billId');
    console.log(this.billId);
  })

}



onSubmit(addPaymentForm:any){

  addPaymentForm.value.customerId=this.customerId;
  addPaymentForm.value.billId=this.billId;
  this.paymentData.customerId= this.customerId;
  this.paymentData.billId= this.billId;
  this.paymentData.paymentMode=addPaymentForm.value.paymentMode;
  this.paymentData.paymentMethod=addPaymentForm.value.paymentMethod;
  this.paymentData.paymentStatus=addPaymentForm.value.paymentStatus;
  this.paymentData.amount=addPaymentForm.value.amount;

  this.paymentService.addPayment(this.customerId,this.billId,this.paymentData).subscribe((res:any)=>{
    console.log(res);
    this.router.navigate([]);
    
  },(error)=>{
    this.errorMessage= error.error;
    console.log(this.errorMessage);
  })

}
 
}
