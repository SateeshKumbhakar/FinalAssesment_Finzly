import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Invoice } from 'src/app/model/invoice';
import { InvoiceService } from 'src/app/myservies/invoice.service';


@Component({
  selector: 'app-add-invoice',
  templateUrl: './add-invoice.component.html',
  styleUrls: ['./add-invoice.component.css']
})
export class AddInvoiceComponent implements OnInit {
 
  customerId !:any;
  billId !:any;
  invoiceData:any = <Invoice>{};
  invoiceError !: any;
  isNotGenerated=false;
 

  
  constructor(private authService:EmpLoginService,private route:ActivatedRoute,private invocieSerive:InvoiceService,private router:Router) { }

  ngOnInit(): void {
    this.authService.isAuthenticate= true;
    this.route.paramMap.subscribe((param)=>{
    this.customerId = param.get('customerId');
    this.billId = param.get('billId');
    console.log(this.billId);
    });
  }
   
 
  

  onSubmit(addInvoiceForm:any){

   this.invocieSerive.addInvoice(this.customerId,this.billId).subscribe((res:any)=>{
    console.log(res);
    this.router.navigate(["/all-invoice"]);

   },(error)=>{

    this.invoiceError= error.error;
    this.isNotGenerated=true;
    console.log(error.error);
   })

  }

}
