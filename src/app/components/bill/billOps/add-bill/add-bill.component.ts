import { Component, OnInit } from '@angular/core';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Bill } from 'src/app/model/bill';
import { BillService } from 'src/app/myservies/bill.service';

@Component({
  selector: 'app-add-bill',
  templateUrl: './add-bill.component.html',
  styleUrls: ['./add-bill.component.css']
})
export class AddBillComponent implements OnInit {
  
  bill: any =<Bill>{}
  constructor(private authService:EmpLoginService,private billService:BillService) { }

  ngOnInit(): void {
    this.authService.isAuthenticate=true;

  }


  onSubmit(addBillForm:any){
    addBillForm = addBillForm.value;
    
    this.bill = {
      billId:addBillForm.billId,
      billDueDate:addBillForm.billDueDate,
      unitConsumption:addBillForm.unitConsumption,
      customerId:addBillForm.customerId,
      billDuration:addBillForm.billDuration,
    }
  
    this.billService.addBill(this.bill,this.bill.customerId).subscribe((res:any)=>{
      console.log(res);
    })

  }

// Define an array of month names
 months: string[] = [
  'January', 'February', 'March', 'April',
  'May', 'June', 'July', 'August',
  'September', 'October', 'November', 'December'
];

// Define a function to create bill duration options
getBillDurationOptions(): { value: string; label: string }[] {
  const options: { value: string; label: string }[] = [];

  for (let i = 0; i < this.months.length - 1; i++) {
    const startMonth = this.months[i];
    const endMonth = this.months[i + 1];
    const optionLabel = `${startMonth}-${endMonth}`;
    options.push({ value: optionLabel.toLowerCase(), label: optionLabel });
  }
  return options;
}

// Create a property to hold the bill duration options
billDurationOptions: { value: string; label: string }[] = this.getBillDurationOptions();


}
