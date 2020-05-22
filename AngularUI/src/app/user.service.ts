import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { account } from './account';
import { user } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  myAccountList: account[];
  headers = new HttpHeaders().set('access-control-allow-origin',"http://localhost:8081/");

  constructor(private http:HttpClient) { }

  public addAccount(acc:account){
    console.log("inside addAccount()");
    return this.http.post<account>("http://localhost:5010/accounts/add",acc);
  }

  public getAccounts(userId){
    console.log("inside getAccounts()");
    return this.http.get<account[]>("http://localhost:5010/accounts/foruser/"+userId);
  }

  public transfer(sender:string,receiver:string,amount:number){
    console.log("inside addAccount()");
    console.log(`http://localhost:5030/fundtransfer/from/${sender}/to/${receiver}/${amount}`);
    return this.http.post<string>("http://localhost:5030/fundtransfer/from/"+sender+"/to/"+receiver+"/"+amount,null);
  }

  public getTransactions(accountNo){
    console.log("inside getTransactions()");
    return this.http.get<account[]>("http://localhost:5060/transactions/transactions/"+accountNo);
  }

  public updateMobile(userId,mobile:string){
    console.log("inside updateMobile()");
    return this.http.put<user>("http://localhost:8081/User/updatemob/accid/"+userId+"/mobileno/"+mobile,null);
  }

  public updateAddress(userId,address:string){
    console.log("inside updateAddress()");
    return this.http.put<user>("http://localhost:8081/User/updateaddress/accid/"+userId+"/address/"+address,null);
  }

}
