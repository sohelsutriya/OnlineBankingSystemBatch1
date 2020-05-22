import { Component, OnInit } from '@angular/core';
import { account } from 'src/app/account';
import { AdminService } from 'src/app/admin.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-allaccounts',
  templateUrl: './allaccounts.component.html',
  styleUrls: ['./allaccounts.component.css']
})
export class AllaccountsComponent implements OnInit {

  allAccountList:account[];

  constructor(private adminServ:AdminService,private toastr: ToastrService) { }

  ngOnInit(): void {
    this.adminServ.getAllAccounts().subscribe(data=>{this.allAccountList=data},
      error => {this.toastr.error("Please try again later","Someting went wrong!")});
  }

}
