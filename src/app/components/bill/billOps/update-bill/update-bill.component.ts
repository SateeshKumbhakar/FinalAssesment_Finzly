import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmpLoginService } from 'src/app/emp-login.service';
import { Bill } from 'src/app/model/bill';
import { BillService } from 'src/app/myservies/bill.service';

@Component({
  selector: 'app-update-bill',
  templateUrl: './update-bill.component.html',
  styleUrls: ['./update-bill.component.css']
})
export class UpdateBillComponent implements OnInit {

  // bill and Customer Id for this component

  customerId: any;
  billId: any;
  updatedBillData: any = <Bill>{};
  errorMessage: string ="";
  isError = true;
  billData: any = <Bill>{}; //for making call to database
  numberPattern = "^[0-9]+$";
  bill: any =<Bill>{}  //For Update

  
  constructor(private billService: BillService, private route: ActivatedRoute, private authService: EmpLoginService) { }

  ngOnInit(): void {
    //Active AuthGard
    this.authService.isAuthenticate = true;
    this.route.paramMap.subscribe((params) => {
      this.customerId = params.get('customerId');
      this.billId = params.get('billId');
      
      //Call While Rendering
      this.getBill();

    });

  }
  

  // Get One Bill With Respect To Customer Id and BillID
  getBill() {
    this.billService.getBill(this.customerId, this.billId).subscribe((res: any) => {

      this.billData = res;
      // let d =this.billData.billDueDate;
      // console.log(d);
      // let date = new Date('2022-12-31T18:40:00.000+00:00');
      // this.datePipe.transform(date,"yyyy-MM-dd");
      // console.log(date);
      
    }, (error) => {
      this.isError=false;
      this.errorMessage = error.error.message;
      console.log(this.errorMessage);
    })
  }


  onUpdateBill(updateBillFormData: any) {
    console.log(updateBillFormData);
    
    this.bill = {
      billId:updateBillFormData.value.billId,
      billDueDate:updateBillFormData.value.billDueDate,
      unitConsumption:updateBillFormData.value.unitConsumption,
      customerId:updateBillFormData.value.customerId,
      billDuration:updateBillFormData.value.billDuration,
      paid:updateBillFormData.value.paid,
    }
    
    this.billService.updateBill(this.customerId, this.billId, this.bill).subscribe((res: any) => {
      console.log(res);
    },
      (error) => {
        this.errorMessage = error.error;
        console.log(this.errorMessage)
      }
    );

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
