import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
// import {baseUrl} from '../environments/environment.prod/environment'

@Injectable({
  providedIn: 'root'
})
export class EmpLoginService {
  isAuthenticate:boolean= false;
  
  baseUrl:string ='http://localhost:8080/api/';

  constructor(private http:HttpClient) { }

  login(requestBody:any):Observable<Object>{
    return this.http.post<Object>(`${this.baseUrl}auth/login`,requestBody);
  }
 
}


