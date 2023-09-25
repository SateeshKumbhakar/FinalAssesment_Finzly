import { Payment } from "./payment";


export interface Transaction{
    transactionId:number
    paymentStatus:boolean;
    amount:number;
    payment:Payment;

}