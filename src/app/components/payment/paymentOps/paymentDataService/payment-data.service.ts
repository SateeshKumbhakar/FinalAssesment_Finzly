import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Payment } from 'src/app/model/payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentDataService {

  constructor() { }

  private paymentDataSubject = new BehaviorSubject<Payment |null>(null);
  paymentData$ = this.paymentDataSubject.asObservable();

    setPaymentData(paymentData: Payment) {
    this.paymentDataSubject.next(paymentData);
  }
}
