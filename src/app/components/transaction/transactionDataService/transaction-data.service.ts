import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Transaction } from 'src/app/model/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionDataService {

  constructor() { }

  
  private transactionDataSubject = new BehaviorSubject<Transaction |null>(null);
  transactionData$ = this.transactionDataSubject.asObservable();

    setTransactionData(transactionData: Transaction) {
    this.transactionDataSubject.next(transactionData);
  }
}
