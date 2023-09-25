import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {
  baseUrl = environment.baseUrl;
  constructor(private http:HttpClient) { }

//Get ALL Invoice
getAllInvoice(): Observable<Object> {
  return this.http.get(`${this.baseUrl}invoices`);
}

// Get A Invoice
getInvoice(invoiceId:number): Observable<Object> {
  return this.http.get(`${this.baseUrl}invoices/${invoiceId}`);
}

//Add new Invoice
 addInvoice(customerId: number, billId: number): Observable<Object> {
  return this.http.post(`${this.baseUrl}customer/${customerId}/${billId}/invoice`,null);
}

// Update Invioce
updateInvioce(customerId: number, billId: number,invoiceId:number,invoiceData: any): Observable<any> {
  return this.http.put(`${this.baseUrl}customer/${customerId}/bill/${billId}/invoices/${invoiceId}`, invoiceData);
}
//delete Invoice
deleteInvoice(invoiceId: number): Observable<any> {
  return this.http.delete(`${this.baseUrl}invoices/${invoiceId}`);
}

}
