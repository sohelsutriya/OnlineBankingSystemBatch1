import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/admin.service';
import { account } from 'src/app/account';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-pendingaccounts',
  templateUrl: './pendingaccounts.component.html',
  styleUrls: ['./pendingaccounts.component.css']
})
export class PendingaccountsComponent implements OnInit {

  pendingList:account[];

  constructor(private adminServ:AdminService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.adminServ.getPendingAccounts().subscribe(data=>{this.pendingList=data},
      error => {this.toastr.error("Please try again later","Someting went wrong!")});
  }

  approve(acc:account){
    this.adminServ.updateAccountStatus("approved",acc).subscribe(data=>{
      this.pendingList.splice(this.pendingList.indexOf(acc),1);
    });
  }

  reject(acc:account){
    this.adminServ.updateAccountStatus("rejected",acc).subscribe(data=>{
      this.pendingList.splice(this.pendingList.indexOf(acc),1);
    });
  }
}
