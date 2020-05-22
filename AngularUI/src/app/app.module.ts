import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegistrationService } from './registration.service';
import { UserUiComponent } from './user-ui/user-ui.component';
import { FundtransferComponent } from './user-ui/fundtransfer/fundtransfer.component';
import { AdminComponent } from './admin/admin.component';
import { AddAccountComponent } from './user-ui/add-account/add-account.component';
import { MyAccountComponent } from './user-ui/my-account/my-account.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { PendingaccountsComponent } from './admin/pendingaccounts/pendingaccounts.component';
import { AllaccountsComponent } from './admin/allaccounts/allaccounts.component';
import { TransactionsComponent } from './admin/transactions/transactions.component';
import { ChangeComponent } from './user-ui/change/change.component';


@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    UserUiComponent,
    FundtransferComponent,
    AdminComponent,
    AddAccountComponent,
    MyAccountComponent,
    FundtransferComponent,
    PendingaccountsComponent,
    AllaccountsComponent,
    TransactionsComponent,
    ChangeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot({
      timeOut: 5000,
      positionClass: 'toast-top-center',
      preventDuplicates: true,
    }) // ToastrModule added
  ],
  providers: [RegistrationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
