import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/user.service';
import { RegistrationService } from 'src/app/registration.service';

@Component({
  selector: 'app-change',
  templateUrl: './change.component.html',
  styleUrls: ['./change.component.css']
})
export class ChangeComponent implements OnInit {

  mobile:string;
  address:string;

  constructor(private userServ:UserService,private regServ:RegistrationService, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  changemobile(){
    console.log("inside changemobile");
    if(this.mobile.match("^((\\+91-?)|0)?[0-9]{10}$")){
      console.log("updating mobile"+this.mobile);
      this.userServ.updateMobile(this.regServ.userId,this.mobile).subscribe(data=>{
        this.mobile="";
        this.toastr.success(data.mobile+' updated Successfully!');  
      });
    }
    else 
      this.toastr.error('Enter Valid Mobile No!');  
  }

  changeaddress(){
    console.log("inside changeaddress");
    if(this.address.length>4){
      console.log("updating address"+this.address);
      this.userServ.updateAddress(this.regServ.userId,this.address).subscribe(data=>{
        this.address="";
        this.toastr.success(data.address+' updated Successfully!');  
      });
    }
    else 
      this.toastr.error('Enter Valid Address!');  
  }

}
