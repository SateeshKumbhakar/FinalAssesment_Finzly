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
   httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'multipart/form-data' })
  };
  baseUrl = environment.baseUrl;
 
  constructor(private http:HttpClient) { }

  getAllCustomer() :Observable<Customer[]>{
   return this.http.get<Customer[]>(`${this.baseUrl}customer/get-all`);
  }

  // Add in bulk
  addBulkCustomer(file:any):Observable<Object>{
    return this.http.post<Object>(`${this.baseUrl}customer/add-customer-in-bulk`,file,this.httpOptions);
  }


  

  


}
