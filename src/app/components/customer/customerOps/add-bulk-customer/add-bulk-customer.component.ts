import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/myservies/customer.service';

@Component({
  selector: 'app-add-bulk-customer',
  templateUrl: './add-bulk-customer.component.html',
  styleUrls: ['./add-bulk-customer.component.css']
})
export class AddBulkCustomerComponent implements OnInit {

  constructor(private customerService:CustomerService) { }
  ngOnInit(): void {
  }

  selectedFile: File | null = null;

  onFileSelected(event: any) {
  this.selectedFile = event.target.files[0] as File;
}
  

  uploadFile() {
    if (!this.selectedFile) {
      console.error('No file selected.');
      return;
    }
    const formData = new FormData();
   formData.append('file', this.selectedFile);

   this.customerService.addBulkCustomer(formData).subscribe(
    (response:any) => {
      console.log('File uploaded successfully.', response);

    },
    (error:any) => {
      console.error('File upload failed.', error);
      // Handle errors here
    }
  );

}



}
