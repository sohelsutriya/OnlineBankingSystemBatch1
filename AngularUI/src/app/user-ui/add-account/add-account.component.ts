import { Component, OnInit } from '@angular/core';
import { account } from 'src/app/account';
import { UserService } from 'src/app/user.service';
import { RegistrationService } from 'src/app/registration.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

  account:account = new account();
  randomNum:number;
  clicked = false;

  constructor(private userservice:UserService, private regservice:RegistrationService, private router:Router, private toastr: ToastrService) { 
    this.randomNum = Math.floor(Math.random() * (999999 - 100000))
    this.account.accountNo = String(this.randomNum);
  }

  ngOnInit(): void {
  }

  addAccount(){
    console.log("inside addAccount()");
    this.account.accountStatus = "pending";
    this.account.userId = String(this.regservice.userId);
    if(this.account.balance>=500){
      this.userservice.addAccount(this.account).subscribe(data =>{
        if(data==null)
          this.toastr.warning("Try Later!"); 
        else
          this.clicked=true;
          this.toastr.success("Account added successfully!","Success!"); 
      });
    }
    else 
      this.toastr.warning("Minimum 500 Opening balance is required!"); 
  }
}
