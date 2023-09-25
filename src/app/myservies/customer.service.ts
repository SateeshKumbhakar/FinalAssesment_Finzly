import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})


export class CustomerService {
  // customers :any []=[];
  //  httpOptions = {
  //   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  // };
  baseUrl = environment.baseUrl;
 
  constructor(private http:HttpClient) { }

  getAllCustomer() :Observable<Customer[]>{
   return this.http.get<Customer[]>(`${this.baseUrl}customer/get-all`);
  }

  // Add in bulk
  addBulkCustomer(file:any):Observable<Object>{
    return this.http.post<Object>(`${this.baseUrl}customer/add-customer-in-bulk`,file);
  }

  // Add in Customer
  addCustomer(customer:any):Observable<any>{
    return this.http.post<any>(`${this.baseUrl}customer/add-customer`,customer);
  }
  // Add in Customer
  getCustomer(customerId:any):Observable<any>{
    return this.http.get<any>(`${this.baseUrl}customer/get-customer/${customerId}`);
  }


  

  


}
