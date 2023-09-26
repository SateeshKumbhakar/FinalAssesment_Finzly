import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';
import { TransactionService } from 'src/app/myservies/transaction.service';
import { TransactionDataService } from './transactionDataService/transaction-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css','../../app.component.css','../bill/bill.component.css']
})
export class TransactionComponent implements OnInit {

  transactions : any =[];
  constructor(private loginService:EmpLoginService,private transactionService:TransactionService,private transactionDataService:TransactionDataService,private router:Router) { }

  ngOnInit(): void {
    this.loginService.isAuthenticate=true;
    this.getAllTransaction();
  }

  // Get All Transaction
  getAllTransaction(){
  this.transactionService.getAllTransaction().subscribe((res:any)=>{
    this.transactions =res;
  },(error:any)=>{
    console.log(error.error);
  })
  }


  viewTransactionDetails(transaction:any){
   this.transactionDataService.setTransactionData(transaction);
   this.router.navigate(['/transaction-details']);
  }
}
