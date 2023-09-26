import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Bill } from 'src/app/model/bill';
import { BillService } from 'src/app/myservies/bill.service';


@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css',"../customer/customerOps/all-customer/all-customer.component.css",'../../app.component.css']
})
export class BillComponent implements OnInit {

  bills:Bill []= [];

  constructor(private billService:BillService,private loginServie:EmpLoginService,private router:Router) { }

  ngOnInit(): void {
    this.loginServie.isAuthenticate = true;
    this.getAllBill();
  }


  getAllBill(){
    this.billService.getAllBill().subscribe((res:any)=>{    
      console.log(res);
     this.bills= res;
    });  
  }

  navigateToBillDetails(billId:number){
   console.log(billId);
   this.router.navigate(["/bill-details",billId]);
  }

  navigateToDeleteBill(customerId:number,billId:number){
    let confirmation = window.confirm('Are you sure you want to delete this record?');
    if (confirmation) {
      this.billService.deleteBill(customerId,billId).subscribe((res)=>{
      //  console.log(res);
       const index = this.bills.indexOf(res);
       console.log(index);
       if(index !== -1){
         this.bills.splice(index,1);
       }
       
      })
    }

  }
  // Navigate for bill Updation
   navigateToUpdateBill(customerId:number,billId:number){
    this.router.navigate(["/update-bill",customerId,billId]);
  }

  //Navigate To Bill Generation
  navigateToInvoiceGeneration(customerId:number, billId:number){
    this.router.navigate(["/add-invoice",customerId,billId]);

  }
  
}
