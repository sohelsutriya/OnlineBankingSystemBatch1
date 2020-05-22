import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { UserUiComponent } from './user-ui/user-ui.component';
import { AdminComponent } from './admin/admin.component';
import { AddAccountComponent } from './user-ui/add-account/add-account.component';
import { FundtransferComponent } from './user-ui/fundtransfer/fundtransfer.component';
import { MyAccountComponent } from './user-ui/my-account/my-account.component';
import { PageNotFoundComponent } from './PageNotFound';
import { AllaccountsComponent } from './admin/allaccounts/allaccounts.component';
import { PendingaccountsComponent } from './admin/pendingaccounts/pendingaccounts.component';
import { TransactionsComponent } from './admin/transactions/transactions.component';
import { ChangeComponent } from './user-ui/change/change.component';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
  {path: '',redirectTo: "/Login", pathMatch: 'full'},
  
  {path:'Login',component:LoginComponent},
  {path:'Register',component:RegistrationComponent},

  {path:'BankUser',component:UserUiComponent,
    children: [
      {path: '', redirectTo: 'MyAccount', pathMatch: 'full'},
      {path:'MyAccount',component:MyAccountComponent},
      {path:'AddAccount',component:AddAccountComponent},
      {path:'Transfer',component:FundtransferComponent},
      {path:'Requests',component:ChangeComponent}
    ]},

  {path:'Admin',component:AdminComponent,
    children: [
      {path:'',component:AllaccountsComponent},
      {path:'Pending',component:PendingaccountsComponent},
      {path:'Transactions',component:TransactionsComponent}
    ]},
    
    { path: '**', component: PageNotFoundComponent }
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
