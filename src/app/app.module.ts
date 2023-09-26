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
import { CustomerDetailsComponent } from './components/customer/customerOps/customer-details/customer-details.component';
import { AddBillComponent } from './components/bill/billOps/add-bill/add-bill.component';
import { UpdateBillComponent } from './components/bill/billOps/update-bill/update-bill.component';
import { DeleteBillComponent } from './components/bill/billOps/delete-bill/delete-bill.component';
import { BillDetailsComponent } from './components/bill/billOps/bill-details/bill-details.component';
import { InvoiceDetailsComponent } from './components/invoice/invoiceOps/invoice-details/invoice-details.component';
import { AddInvoiceComponent } from './components/invoice/invoiceOps/add-invoice/add-invoice.component';
import { AllInvoiceComponent } from './components/invoice/invoiceOps/all-invoice/all-invoice.component';
import { UpdateInvoiceComponent } from './components/invoice/invoiceOps/update-invoice/update-invoice.component';
import { AllTransactionComponent } from './components/transaction/transactionOps/all-transaction/all-transaction.component';
import { AddTransactionComponent } from './components/transaction/transactionOps/add-transaction/add-transaction.component';
import { TransactionDetailsComponent } from './components/transaction/transactionOps/transaction-details/transaction-details.component';
import { AddPaymentComponent } from './components/payment/paymentOps/add-payment/add-payment.component';
import { UpdatePaymentComponent } from './components/payment/paymentOps/update-payment/update-payment.component';
import { AllPaymentComponent } from './components/payment/paymentOps/all-payment/all-payment.component';
import { PaymentDetailsComponent } from './components/payment/paymentOps/payment-details/payment-details.component';


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
     CustomerDetailsComponent,
     AddBillComponent,
     UpdateBillComponent,
     DeleteBillComponent,
     BillDetailsComponent,
     InvoiceDetailsComponent,
     AddInvoiceComponent,
     AllInvoiceComponent,
     UpdateInvoiceComponent,
     AllTransactionComponent,
     AddTransactionComponent,
     TransactionDetailsComponent,
     AddPaymentComponent,
     UpdatePaymentComponent,
     AllPaymentComponent,
     PaymentDetailsComponent,
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
