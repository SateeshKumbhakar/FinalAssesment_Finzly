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

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: "login", component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: "dashboard", component: DashboardComponent, canActivate :[AuthGuard]},
  { path: "customer", component: CustomerComponent, canActivate :[AuthGuard]},
  { path: "bill", component: BillComponent, canActivate :[AuthGuard]},
  
  { path: "invoice", component: InvoiceComponent, canActivate :[AuthGuard]},
  { path: "payment", component: PaymentComponent, canActivate :[AuthGuard]},
  { path: "transaction", component: TransactionComponent, canActivate :[AuthGuard]},
  
  { path: "add-new-customer", component: AddCustomerComponent, canActivate :[AuthGuard]},
  { path: "add-in-bulk", component: AddBulkCustomerComponent, canActivate :[AuthGuard]},
  { path: "customer-details/:id", component: CustomerDetailsComponent, canActivate :[AuthGuard]},
  { path: "all-customer", component: AllCustomerComponent, canActivate :[AuthGuard]},
  { path: "update-customer", component: UpdateCustomerComponent, canActivate :[AuthGuard]},
  { path: "delete-customer", component: DeleteCustomerComponent, canActivate :[AuthGuard]},

  { path: "bill", component: BillComponent, canActivate :[AuthGuard]},
  { path: "add-bill", component: AddBillComponent, canActivate :[AuthGuard]},
  { path: "update-bill/:customerId/:billId", component: UpdateBillComponent, canActivate :[AuthGuard]},
  { path: "delete-bill", component: DeleteBillComponent, canActivate :[AuthGuard]},

  
  
  { path: '404', component: PagenotfoundComponent },
  { path: '**', redirectTo: '404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
