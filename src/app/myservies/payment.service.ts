import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  //get All Payments
  getAllPayment(): Observable<Object> {
    return this.http.get(`${this.baseUrl}payments`);
  }

  //Get A Payment
  getPayment(paymentId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}payments/${paymentId}`);
  }

  //Add New Payment
  addPayment(customerId: number, billId: number, paymentData: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}customer/${customerId}/${billId}/payment`, paymentData);
  }

  //Update Payment
  updatePayment(paymentId: number, paymentData: any): Observable<any> {
    return this.http.put(`${this.baseUrl}payments/${paymentId}`, paymentData);
  }
  //Delete Payment
  deletePayment(paymentId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}payments/${paymentId}`);
  }
}