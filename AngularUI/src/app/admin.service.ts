import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { account } from './account';
import { transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  public getAllAccounts(){
    console.log("inside getAllAccounts()");
    return this.http.get<account[]>("http://localhost:5010/accounts/get");
  }

  public getPendingAccounts(){
    console.log("inside getPendingAccounts()");
    return this.http.get<account[]>("http://localhost:5010/accounts/pending");
  }

  public getAllTransactions(){
    console.log("inside getAllTransactions()");
    return this.http.get<transaction[]>("http://localhost:5060/transactions/transactions");
  }

  public updateAccountStatus(status:string,acc:account){
    console.log("inside updateAccountStatus()");
    console.log(status);
    console.log(acc);
    return this.http.put<account>("http://localhost:5010/accounts/updatestatus/"+status,acc);
  }

}
