import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { user } from '../user';
import {Router} from "@angular/router"
import { logincredentials } from '../logincredentials';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  usr:user = new user();
  lc:logincredentials = new logincredentials();
  abc:any;

  constructor(private service:RegistrationService,private router: Router,private toastr: ToastrService) { }

  ngOnInit(): void {
    //this.usr = new user();
  }

  addNewUser(){
    console.log(this.usr);
    if(this.usr.pan==null||this.usr.mobile==null||this.usr.address==null||this.usr.fname==null||this.usr.lname==null
      ||this.usr.pan==""||this.usr.mobile==""||this.usr.address==""||this.usr.fname==""||this.usr.lname==""||
      !this.usr.pan.match("[A-Za-z]{5}[0-9]{4}[a-zA-Z]") || !this.usr.mobile.match("^((\\+91-?)|0)?[0-9]{10}$") || !this.usr.address.match("[a-zA-Z ]*") ||
       !this.usr.fname.match("[a-zA-Z ]*") || !this.usr.lname.match("[a-zA-Z ]*") || !this.usr.email.match("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")){
      console.log(this.usr);
      this.toastr.error('Invalid Input!');  
    }
    else{
      this.abc = this.service.addUser(this.usr)
        .subscribe( data => {
        });
    this.lc.username = this.usr.email;
    this.lc.role="user";
    this.service.addLoginCredentials(this.lc)
        .subscribe(data => {
          this.toastr.success('Registered Successfully!');  
            this.router.navigate(['Login'])
          });
    }
  }
  
}
