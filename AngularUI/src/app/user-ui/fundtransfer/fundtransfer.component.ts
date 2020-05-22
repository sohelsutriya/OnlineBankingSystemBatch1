import { Component, OnInit, Input } from '@angular/core';
import { UserService } from 'src/app/user.service';
import { ToastrService } from 'ngx-toastr';
import { account } from 'src/app/account';

@Component({
  selector: 'app-fundtransfer',
  templateUrl: './fundtransfer.component.html',
  styleUrls: ['./fundtransfer.component.css']
})
export class FundtransferComponent implements OnInit {

  myAccountList:account[];
  myAccountNo;
  receiverAccountNo;
  amount;

  constructor(private userService: UserService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.amount=0;
    this.myAccountList= this.userService.myAccountList;
  }

  validateForTransfer(){
    if(this.amount>0){
      let accFound =false;
      console.log(this.myAccountList);
      this.myAccountList.forEach(
        a=>{
          if(a.accountNo==this.myAccountNo){
            accFound=true;
            if(a.accountStatus=="approved")
              if(a.balance-this.amount>499)
                this.transfer();
              else
              this.toastr.error('Minimum 500 Balance is required');
            else
              this.toastr.warning('Account not Approved');
          } 
        }
        );
      if(!accFound)
        this.toastr.error('Please Check Your Account No!','Error');
    }
    else
     this.toastr.warning('Enter Valid Amount');
  }

  transfer(){
    console.log("inside transfer");
    this.userService.transfer(this.myAccountNo,this.receiverAccountNo,this.amount).subscribe(data=>{
      if(data!=null){
        this.toastr.success('Transfer Successfull!')
      }
      else{
        this.toastr.error('Something went wrong!');
      }
    });
    this.myAccountNo="";
    this.receiverAccountNo="";
    this.amount=0;
  }

}
