import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';
import { PaymentService } from 'src/app/myservies/payment.service';
import { PaymentDataService } from '../paymentDataService/payment-data.service';

@Component({
  selector: 'app-update-payment',
  templateUrl: './update-payment.component.html',
  styleUrls: ['./update-payment.component.css']
})
export class UpdatePaymentComponent implements OnInit {

  payment: any = {};
  errorMessage :any;
  isError =true;
  
  paymentModeOptions=["Online","Cash"];
  paymentMethodOptions=["Credit Card","Debit Card","Wallet"];
  paymentStatus = ["SUCCESS","FAILDED","PENDING"];

  constructor(private authSerive: EmpLoginService,
    private paymentService: PaymentService,
    private paymentDataService:PaymentDataService) { }

  ngOnInit(): void {
    this.authSerive.isAuthenticate = true;
    this.fetchPaymentData()
  }

  //It custome service logic
  fetchPaymentData(){
    this.paymentDataService.paymentData$.subscribe((res:any)=>{
      this.payment = res;
      console.log(this.payment);
    })
  }

  onUpdate(formData:any){

  }

}
