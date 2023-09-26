import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { InvoiceService } from 'src/app/myservies/invoice.service';
import { InvoiceDataService } from '../../invoiceService/invoice-data.service';
 

@Component({
  selector: 'app-all-invoice',
  templateUrl: './all-invoice.component.html',
  styleUrls: ['./all-invoice.component.css','../../../bill/bill.component.css','../../../../app.component.css']
})
export class AllInvoiceComponent implements OnInit {

  invoices: any = [];
  errorMsg :any;
  isDeleted=false;
  isNotFound=false;
  noInvoice:any;

  constructor(private authService: EmpLoginService, private route: ActivatedRoute, private invocieSerive: InvoiceService, private router: Router,private invoiceDataService:InvoiceDataService) { 
  }

  ngOnInit(): void {
    this.authService.isAuthenticate = true;
    this.getAllInvoice();
  }

  

  //get All Invoices Here
  getAllInvoice() {
    this.invocieSerive.getAllInvoice().subscribe((res: any) => {
      this.invoices = res;
      console.log(res);
    }, (error) => {

      this.noInvoice=error.error;
      this.isNotFound=true;
      console.log(error.error);
    })
  }


  navigateToDeleteInvoice(invoiceId: number) {
    let confirmation = window.confirm('Are you sure you want to delete this Inovice?');
    if (confirmation) {
    this.invocieSerive.deleteInvoice(invoiceId).subscribe((res:any)=>{
      console.log(res);
      // this.invoices.splice(this.invoices.indexOf(res),1);
    },(error)=>{
       this.errorMsg= error.error;
       this.isDeleted= true;
       console.log(error.error);
      // alert(error.error);
    })
  }
  }
  navigateToUpdateInvoice(customerId: number, billId: number, invoiceId: number) {

    this.router.navigate(["/update-invoice", customerId, billId, invoiceId])
  }

  navigateToInvoiceDetails(invoice:any) {
    this.invoiceDataService.setInvoiceData(invoice);
    this.router.navigate(["/invoice-details"]);
  }

  navigateToPayment(customerId:number,billId:number){
    this.router.navigate(["/add-payment",customerId,billId]);
  }
}
