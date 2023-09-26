import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Invoice } from 'src/app/model/invoice';
import { InvoiceService } from 'src/app/myservies/invoice.service';
import { InvoiceDataService } from '../../invoiceService/invoice-data.service';

@Component({
  selector: 'app-invoice-details',
  templateUrl: './invoice-details.component.html',
  styleUrls: ['./invoice-details.component.css']
})
export class InvoiceDetailsComponent implements OnInit {
  
   

  invoice: any = <Invoice>{};
  invoiceId: any;
  constructor(private authService: EmpLoginService, private route: ActivatedRoute, private invocieSerive: InvoiceService, private router: Router,private invoiceDataService:InvoiceDataService) { }

  ngOnInit(): void {
    this.authService.isAuthenticate = true;
    // this.route.paramMap.subscribe((param) => {
    //   this.invoiceId = param.get('invoiceId');
    // });
    // this.getOneInvoice(this.invoiceId);
    
    this.fetchData();
   
  }

  fetchData(){
    this.invoiceDataService.invoiceData$.subscribe((res:any)=>{
      this.invoice=res;
      console.log(this.invoice);
    })
  }
 

  // getOneInvoice(invoiceId: number) {

  //   this.invocieSerive.getInvoice(invoiceId).subscribe((res: any) => {
  //     this.invoice = res;
  //     // console.log(this.invoice);
  //   }, (error) => {
  //     console.log(error.error);
  //   })
  // }
  


  //Jugad
  // fillData(){
  //   this.getOneInvoice();
  // }
}
