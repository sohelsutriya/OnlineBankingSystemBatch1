import { Component, OnInit } from '@angular/core';
import { transaction } from 'src/app/transaction';
import { AdminService } from 'src/app/admin.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  transactionList:transaction[];

  constructor(private adminServ:AdminService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.adminServ.getAllTransactions().subscribe(data=>{this.transactionList=data},
      error => {this.toastr.error("Please try again later","Someting went wrong!")});
  }

}
