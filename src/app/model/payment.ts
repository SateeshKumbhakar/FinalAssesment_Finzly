import { Bill } from "./bill";
import {  Customer } from "./customer";

export interface Payment{
    paymentId:number;
    paymentMode:string;
    paymentMethod:string;
    paymentStatus:boolean;
    amount:number;
    referenceNo:string;
    customer:Customer;
    bill:Bill;
}

