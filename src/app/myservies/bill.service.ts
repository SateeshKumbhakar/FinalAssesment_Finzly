import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BillService {
  baseUrl = environment.baseUrl;
  constructor(private http: HttpClient) { }

  //get All Bill 
  getAllBill(): Observable<Object> {
    return this.http.get(`${this.baseUrl}all-bill`);
  }

  // 
  addBill(bill: any, customerId: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}customer/${customerId}/bill`, bill);
  }

  // Add A Bill
  getBill(customerId: any, billId: any): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}customer/${customerId}/bill/${billId}`);
  }
  // Customer  All Bill
  getCustomerAllBill(customerId: any, billId: any): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}customer/${customerId}/bill/${billId}`);
  }

  // Update Bill
  updateBill(customerId:number,billId:number,billData:any):Observable<any>{
     return this.http.put(`${this.baseUrl}customer/${customerId}/bill/${billId}`,billData);
  }

  // Delete the Bill
  deleteBill(customerId:number,billId:number):Observable<any>{
    return this.http.delete(`${this.baseUrl}customer/${customerId}/bill/${billId}`);
  }
  
}
