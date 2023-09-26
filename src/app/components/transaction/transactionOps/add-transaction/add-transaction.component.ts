import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentDataService } from 'src/app/components/payment/paymentOps/paymentDataService/payment-data.service';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Transaction } from 'src/app/model/transaction';
import { TransactionService } from 'src/app/myservies/transaction.service';

@Component({
  selector: 'app-add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.css']
})
export class AddTransactionComponent implements OnInit {

  payment:any;
  transactionData:any= <Transaction>{};
  constructor(private transactionService:TransactionService,private route:ActivatedRoute,private authService:EmpLoginService,private paymentDataService:PaymentDataService,private router:Router) { }

  ngOnInit(): void {
    this.authService.isAuthenticate = true;
     

    //Fetch One Load
    // this.getOnePayment();
    this.fetchPaymentData();
    this.addTransaction();
  }


  //It custome service logic
  fetchPaymentData(){
    this.paymentDataService.paymentData$.subscribe((res:any)=>{
      this.payment = res;
      console.log(this.payment);
      this.transactionData.paymentId= this.payment.paymentId;
      this.transactionData.amount = this.payment.amount;
      this.transactionData.paymentStatus = this.payment.paymentStatus;
    })

  }
   
   addTransaction(){
    this.transactionService.addTransaction(this.payment.paymentId,this.transactionData).subscribe((res: any) => {
          console.log(res);
          this.router.navigate(["/transaction"]);
        }, (error) => {
          console.log(error.error);
        });
     
   }


}
