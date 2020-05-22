import { Component, OnInit } from '@angular/core';
import { account } from 'src/app/account';
import { UserService } from 'src/app/user.service';
import { UserUiComponent } from '../user-ui.component';
import * as XLSX from 'xlsx';
import { transaction } from 'src/app/transaction';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.css']
})
export class MyAccountComponent implements OnInit {

  myAccountsList:account[];
  myTransactions:transaction[];

  constructor(private userService:UserService, private userComp:UserUiComponent,private toastr: ToastrService) { }

  ngOnInit(): void {
    this.loadMyAccounts();
  }

  loadMyAccounts(){
    this.userService.getAccounts(this.userComp.myUserId).subscribe(data =>{
      this.myAccountsList = data;
      this.userService.myAccountList = data;
    },
    error => {this.toastr.error("Please try again later","Someting went wrong!")}
    );
  }

  export(accNo:string){
    console.log("inside export");
    this.userService.getTransactions(accNo).subscribe(
      data=>{
        const ws: XLSX.WorkSheet = XLSX.utils.json_to_sheet(data);
        const wb: XLSX.WorkBook = XLSX.utils.book_new();
        XLSX.utils.book_append_sheet(wb, ws, accNo);
        XLSX.writeFile(wb, accNo+'.xlsx');
      }
    );
  }

}
