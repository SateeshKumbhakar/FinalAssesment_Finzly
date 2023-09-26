import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AuthGuard } from './auth.guard';
import { TransactionComponent } from './components/transaction/transaction.component';
import { PaymentComponent } from './components/payment/payment.component';
import { InvoiceComponent } from './components/invoice/invoice.component';
import { BillComponent } from './components/bill/bill.component';
import { CustomerComponent } from './components/customer/customer.component';
import { AddCustomerComponent } from './components/customer/customerOps/add-customer/add-customer.component';
import { AddBulkCustomerComponent } from './components/customer/customerOps/add-bulk-customer/add-bulk-customer.component';
import { DeleteCustomerComponent } from './components/customer/customerOps/delete-customer/delete-customer.component';
import { AllCustomerComponent } from './components/customer/customerOps/all-customer/all-customer.component';
import { UpdateCustomerComponent } from './components/customer/customerOps/update-customer/update-customer.component';
import { CustomerDetailsComponent } from './components/customer/customerOps/customer-details/customer-details.component';
import { DeleteBillComponent } from './components/bill/billOps/delete-bill/delete-bill.component';
import { UpdateBillComponent } from './components/bill/billOps/update-bill/update-bill.component';
import { AddBillComponent } from './components/bill/billOps/add-bill/add-bill.component';
import { AllInvoiceComponent } from './components/invoice/invoiceOps/all-invoice/all-invoice.component';
import { UpdateInvoiceComponent } from './components/invoice/invoiceOps/update-invoice/update-invoice.component';
import { InvoiceDetailsComponent } from './components/invoice/invoiceOps/invoice-details/invoice-details.component';
import { AddInvoiceComponent } from './components/invoice/invoiceOps/add-invoice/add-invoice.component';
import { AllTransactionComponent } from './components/transaction/transactionOps/all-transaction/all-transaction.component';
import { AddTransactionComponent } from './components/transaction/transactionOps/add-transaction/add-transaction.component';
import { TransactionDetailsComponent } from './components/transaction/transactionOps/transaction-details/transaction-details.component';
import { AllPaymentComponent } from './components/payment/paymentOps/all-payment/all-payment.component';
import { AddPaymentComponent } from './components/payment/paymentOps/add-payment/add-payment.component';
import { UpdatePaymentComponent } from './components/payment/paymentOps/update-payment/update-payment.component';
import { PaymentDetailsComponent } from './components/payment/paymentOps/payment-details/payment-details.component';

const routes: Routes = [
  //Starting Route
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: "login", component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: "dashboard", component: DashboardComponent, canActivate :[AuthGuard]},
  { path: "customer", component: CustomerComponent, canActivate :[AuthGuard]},
  { path: "bill", component: BillComponent, canActivate :[AuthGuard]},

  //Main Route
  { path: "invoice", component: InvoiceComponent, canActivate :[AuthGuard]},
  { path: "payment", component: PaymentComponent, canActivate :[AuthGuard]},
  { path: "transaction", component: TransactionComponent, canActivate :[AuthGuard]},

  //Customer Routes
  { path: "add-new-customer", component: AddCustomerComponent, canActivate :[AuthGuard]},
  { path: "add-in-bulk", component: AddBulkCustomerComponent, canActivate :[AuthGuard]},
  { path: "customer-details/:id", component: CustomerDetailsComponent, canActivate :[AuthGuard]},
  { path: "all-customer", component: AllCustomerComponent, canActivate :[AuthGuard]},
  { path: "update-customer", component: UpdateCustomerComponent, canActivate :[AuthGuard]},
  { path: "delete-customer", component: DeleteCustomerComponent, canActivate :[AuthGuard]},
  
  //Bill Route
  { path: "bill", component: BillComponent, canActivate :[AuthGuard]},
  { path: "add-bill", component: AddBillComponent, canActivate :[AuthGuard]},
  { path: "update-bill/:customerId/:billId", component: UpdateBillComponent, canActivate :[AuthGuard]},
  { path: "delete-bill", component: DeleteBillComponent, canActivate :[AuthGuard]},

  //Invoice Route
  { path: "all-invoice", component: AllInvoiceComponent, canActivate :[AuthGuard]},
  { path: "update-invoice/:customerId/:billId/:invoiceId", component: UpdateInvoiceComponent, canActivate :[AuthGuard]},
  { path: "add-invoice/:customerId/:billId", component: AddInvoiceComponent, canActivate :[AuthGuard]},
  { path: "invoice-details", component: InvoiceDetailsComponent, canActivate :[AuthGuard]},

  //Payments Route
  { path: "all-payment", component: AllPaymentComponent, canActivate :[AuthGuard]},
  { path: "add-payment/:customerId/:billId", component: AddPaymentComponent, canActivate :[AuthGuard]},
  { path: "update-payment", component: UpdatePaymentComponent, canActivate :[AuthGuard]},
  { path: "payment-details", component: PaymentDetailsComponent, canActivate :[AuthGuard]},

  //Transactions Route
  { path: "all-transaction", component: AllTransactionComponent, canActivate :[AuthGuard]},
  { path: "add-transaction", component: AddTransactionComponent, canActivate :[AuthGuard]},
  { path: "transaction-details", component: TransactionDetailsComponent, canActivate :[AuthGuard]},

  
  //Not Found Route
  { path: '404', component: PagenotfoundComponent },
  { path: '**', redirectTo: '404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
