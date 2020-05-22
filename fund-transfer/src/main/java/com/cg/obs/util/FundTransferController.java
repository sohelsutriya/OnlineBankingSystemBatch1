/**
 * 
 */
package com.cg.obs.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obs.model.Account;
import com.cg.obs.model.Transaction;
import com.cg.obs.model.TransactionType;
import com.cg.obs.service.FundTransferService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author sohel
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@Api
public class FundTransferController {
	@Autowired
	FundTransferService service;

	
	@ApiOperation(value = "fundTransfer", nickname = "fundTransfer")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Transaction.class),
			@ApiResponse(code = 500, message = "Failure", response = Transaction.class) })
	@PostMapping(path = "/fundtransfer/from/{senderAccountNo}/to/{recieverAccountNo}/{amount}")
	public Account fundTransfer(@PathVariable String senderAccountNo, @PathVariable String recieverAccountNo,
			@PathVariable double amount) {
		System.out.println("this will transfer funds from one account to other and update transactions also");
		System.out.println(senderAccountNo + recieverAccountNo + amount);
		Account senderAccount = service.getAccountByAccountNo(senderAccountNo);
		double newbal = senderAccount.getBalance() - amount;
		senderAccount.setBalance(senderAccount.getBalance() - amount);
		service.updateAccount(senderAccount);
		service.postTransaction(new Transaction("Debit", new Date(), amount, senderAccountNo));
		Account recieverAccount = service.getAccountByAccountNo(recieverAccountNo);
		recieverAccount.setBalance(recieverAccount.getBalance() + amount);
		service.updateAccount(recieverAccount);
		service.postTransaction(new Transaction("Credit", new Date(), amount, recieverAccountNo));
		return recieverAccount;
	}
}
