import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { user } from './user';
import { logincredentials } from './logincredentials';


@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  userId:number;

  constructor(private http:HttpClient) { }

  public addUser(usr:user){
    console.log("inside addUser()");
    return this.http.post<user>("http://localhost:8081/User/add",usr);
  }

  public addLoginCredentials(lc:logincredentials){
    console.log("inside addLoginCredentials()");
    return this.http.post<logincredentials>("http://localhost:8082/AddLogin",lc);
  }

  public login(lc:logincredentials){
    console.log("inside login()");
    return this.http.post<logincredentials>("http://localhost:8082/Login",lc);
  }

  public getAllCredentials() {
    return this.http.get<logincredentials[]>("http://localhost:8082/getAllLoginCredentials");
  }

}
