import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Payment } from 'src/app/model/payment';
import { PaymentService } from 'src/app/myservies/payment.service';
import { PaymentDataService } from '../paymentDataService/payment-data.service';

@Component({
  selector: 'app-payment-details',
  templateUrl: './payment-details.component.html',
  styleUrls: ['./payment-details.component.css']
})
export class PaymentDetailsComponent implements OnInit {

  paymentId: any;
  payment: any = {};

  constructor(private route: ActivatedRoute,
    private authSerive: EmpLoginService,
    private paymentService: PaymentService,
    private paymentDataService:PaymentDataService) { }

   ngOnInit(): void {
    this.authSerive.isAuthenticate = true;
     

    //Fetch One Load
    // this.getOnePayment();
    this.fetchPaymentData();
  }


  //It custome service logic
  fetchPaymentData(){
    this.paymentDataService.paymentData$.subscribe((res:any)=>{
      this.payment = res;
      console.log(this.payment);

    })
  }
  // // Get One Payment
  // getOnePayment() {
  //   this.paymentService.getPayment(this.paymentId).subscribe((res: any) => {
  //     // console.log(res);
  //     this.payment = res;
  //     console.log(this.payment);
  //   }, (error) => {
  //     console.log(error.error);
  //   });
  // }
}
