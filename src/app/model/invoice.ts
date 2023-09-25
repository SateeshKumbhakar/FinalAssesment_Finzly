import { Bill } from "./bill";
import { Customer } from "./customer";

export interface Invoice{
    invoiceId:number;
    amount:number;
    billDueDate:Date;
    earlyPayment:number;
    onlinePayment:number;
    totalAmount:number;
    paymentStatus:boolean;
    customer:Customer;
    bill:Bill;

}