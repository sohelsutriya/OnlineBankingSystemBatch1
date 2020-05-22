/**
 * 
 */
package com.cg.obs.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obs.model.Transaction;
import com.cg.obs.service.TransactionService;

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
public class TransactionController {
	@Autowired
	private TransactionService service;

	@GetMapping(path = "/transactions")
	@ApiOperation(value = "getAllTransactions", nickname = "getAllTransactions")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Transaction.class),
			@ApiResponse(code = 500, message = "Failure", response = Transaction.class) })
	public List<Transaction> getAllTransactions() {
		System.out.println("This will return list of all transactions");
		return service.findAll();
	}

	@GetMapping(path = "/transactions/{accountNo}")
	@ApiOperation(value = "getTransactionByAccountNo", nickname = "getTransactionByAccountNo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Transaction.class),
			@ApiResponse(code = 500, message = "Failure", response = Transaction.class) })
	public List<Transaction> getTransactionByAccountNo(@PathVariable String accountNo) {
		System.out.println("this will return transaction for account");
		return service.findAll().stream().filter(x -> (x.getAccountNo().equals(accountNo)))
				.collect(Collectors.toList());
	}

	@PostMapping(path = "/transactions/add")
	@ApiOperation(value = "addTransaction", nickname = "addTransaction")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Transaction.class),
			@ApiResponse(code = 500, message = "Failure", response = Transaction.class) })
	public String addTransaction(@RequestBody Transaction transaction) {
		System.out.println("this will add transaction into db");
		service.save(transaction);
		return "transaction added";
	}
}
