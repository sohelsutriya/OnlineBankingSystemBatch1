import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  sidenavwidth:Number;
  mainwidth:Number;
  sidenavmargin:Number;
  mainmargin:Number;
  
  constructor(private router:Router) { }

  openNav(){
    this.mainmargin=250;
    this.sidenavwidth=250;
  }

  closeNav(){
    this.mainmargin=0;
    this.sidenavwidth=0;
  }

  ngOnInit(): void {
    this.mainmargin=250;
    this.sidenavwidth=250;
    if(sessionStorage.getItem("role")!="admin")
      this.router.navigate(['']);
  }

  logout(){
    sessionStorage.removeItem("role");
    this.router.navigate(['']);
  }

}
