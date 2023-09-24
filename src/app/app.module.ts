import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { CenterComponent } from './center/center.component';
import { LoginComponent } from './login/login.component';

import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule}  from '@angular/common/http';
import { CustomerComponent } from './components/customer/customer.component';
import { BillComponent } from './components/bill/bill.component';
import { InvoiceComponent } from './components/invoice/invoice.component';
import { PaymentComponent } from './components/payment/payment.component';
import { TransactionComponent } from './components/transaction/transaction.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AddCustomerComponent } from './components/customer/customerOps/add-customer/add-customer.component';
import { AddBulkCustomerComponent } from './components/customer/customerOps/add-bulk-customer/add-bulk-customer.component';
import { AllCustomerComponent } from './components/customer/customerOps/all-customer/all-customer.component';
import { UpdateCustomerComponent } from './components/customer/customerOps/update-customer/update-customer.component';
import { DeleteCustomerComponent } from './components/customer/customerOps/delete-customer/delete-customer.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    CenterComponent,
    LoginComponent,
    PagenotfoundComponent,
     CustomerComponent,
     BillComponent,
     InvoiceComponent,
     PaymentComponent,
     TransactionComponent,
     DashboardComponent,
     AddCustomerComponent,
     AddBulkCustomerComponent,
     AllCustomerComponent,
     UpdateCustomerComponent,
     DeleteCustomerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
