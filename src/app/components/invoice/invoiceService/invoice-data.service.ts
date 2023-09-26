import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Invoice } from 'src/app/model/invoice';

@Injectable({
  providedIn: 'root'
})
export class InvoiceDataService {

  private invoiceDataSubject = new BehaviorSubject<Invoice | null>(null);
  invoiceData$ = this.invoiceDataSubject.asObservable();
  
    setInvoiceData(invoiceData: Invoice) {
    this.invoiceDataSubject.next(invoiceData);
  }
}
