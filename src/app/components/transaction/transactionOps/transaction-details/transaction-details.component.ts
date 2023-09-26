import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';
import { TransactionService } from 'src/app/myservies/transaction.service';
import { TransactionDataService } from '../../transactionDataService/transaction-data.service';
import { Transaction } from 'src/app/model/transaction';



@Component({
  selector: 'app-transaction-details',
  templateUrl: './transaction-details.component.html',
  styleUrls: ['./transaction-details.component.css']
})
export class TransactionDetailsComponent implements OnInit {

  transaction : any =<Transaction>{}
  constructor(
    private authSerive: EmpLoginService,
    private paymentService: TransactionService,
    private transactionDataService:TransactionDataService) { }

  ngOnInit(): void {
    this.authSerive.isAuthenticate = true;
     

    //Fetch One Load
    // this.getOnePayment();
    this.fetchTransactionData();
  }

  //It custome service logic
  fetchTransactionData(){
    this.transactionDataService.transactionData$.subscribe((res:any)=>{
      this.transaction = res;
      console.log(this.transaction);

    })
  }
}
