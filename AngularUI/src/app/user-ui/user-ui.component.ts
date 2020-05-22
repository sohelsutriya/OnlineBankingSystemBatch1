import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-ui',
  templateUrl: './user-ui.component.html',
  styleUrls: ['./user-ui.component.css']
})
export class UserUiComponent implements OnInit {

  sidenavwidth:Number;
  mainwidth:Number;
  sidenavmargin:Number;
  mainmargin:Number;

  myUserId;
  constructor(private registerService:RegistrationService, private router:Router) { }

  openNav(){
    this.mainmargin=250;
    this.sidenavwidth=250;
  }

  closeNav(){
    this.mainmargin=0;
    this.sidenavwidth=0;
  }

  ngOnInit(): void {
    this.myUserId = this.registerService.userId;
    this.mainmargin=250;
    this.sidenavwidth=250;
    if(sessionStorage.getItem("role")!="user")
      this.router.navigate(['']);
  }

  logout(){
    sessionStorage.removeItem("role");
    this.router.navigate(['']);
  }

}

