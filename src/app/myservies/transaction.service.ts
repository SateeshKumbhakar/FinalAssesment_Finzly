import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  baseUrl = environment.baseUrl;
  constructor(private http:HttpClient) { }


   //get All Transactions
   getAllTransaction(): Observable<Object> {
    return this.http.get(`${this.baseUrl}transactions`);
  }
  //Get A Transaction
  getTransaction(transactionId:number):Observable<any>{
    return this.http.get(`${this.baseUrl}transactions/${transactionId}`);
  }
  //Add New Tranaction
  addTransaction( paymentId:number,transaction:any): Observable<Object> {   
    return this.http.post(`${this.baseUrl}customer/${paymentId}/transaction`,transaction); 
  }

  //Update Transaction
  updateTransaction(customerId:number,billId:number,transactionId:number, transactionData:any):Observable<any>{
    return this.http.put(`${this.baseUrl}customer/${customerId}/bill/${billId}/transaction/${transactionId}`,transactionData);
 }

 //Delete Transaction
 deleteTransaction(transactionId:number):Observable<any>{
  return this.http.delete(`${this.baseUrl}transactions/${transactionId}`);
}

}
