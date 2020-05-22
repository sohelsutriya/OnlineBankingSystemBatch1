import { Component, OnInit, ViewChild } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { logincredentials } from '../logincredentials';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  lc:logincredentials = new logincredentials();
  logincred_list:logincredentials[];
  userFound:boolean = false;
  result;

  constructor(private service:RegistrationService,private router: Router,private toastr: ToastrService) { }

  ngOnInit(): void {
    this.service.getAllCredentials().subscribe(data =>{this.logincred_list = data});
  }

  login(){
    this.logincred_list.forEach(cred => {
      if(cred.username==this.lc.username){
        if(cred.password==this.lc.password){
          this.userFound = true;
          this.service.userId = cred.userId;
          sessionStorage.setItem("role",String(cred.role));
          if(cred.role=="user")
            this.router.navigate(['/BankUser'])
          else
          this.router.navigate(['/Admin'])
        }
      }
    });
    if(!this.userFound)
      this.toastr.error('Please enter valid credentials','Wrong Credentials');  
      //alert("user Not Found");
    
  }

}
