/**
 * 
 */
package com.cg.obs.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obs.excetption.AccountNotFoundException;
import com.cg.obs.model.Account;
import com.cg.obs.service.AccountService;

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
public class AccountController {
	@Autowired
	private AccountService service;

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@GetMapping(path = "/accounts/get")
	@ApiOperation(value = "getAllAccounts", nickname = "getAllAccounts")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Account.class),
			@ApiResponse(code = 500, message = "Failure", response = Account.class) })
	public List<Account> getAllAccounts() {
		System.out.println("this function will return list of all accunts");
		return service.findAll();
	}

	@GetMapping(path = "/accounts/{accountNo}")
	@ApiOperation(value = "getAccountByAccountNo", nickname = "getAccountByAccountNo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Account.class),
			@ApiResponse(code = 500, message = "Failure", response = Account.class) })
	public Account getAccountByAccountNo(@PathVariable String accountNo) throws AccountNotFoundException {
		System.out.println("This function will return account by accountNo");
		// Account account=service.findById(accountNo).get();
		return service.findAccountByAccountNo(accountNo);
	}

	@GetMapping(path = "/accounts/pending")
	@ApiOperation(value = "getPendingAccounts", nickname = "getPendingAccounts")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Account.class),
			@ApiResponse(code = 500, message = "Failure", response = Account.class) })
	public List<Account> getPendingAccounts() {
		System.out.println("This function will return list of all pending account");
		return service.findPendingAccounts();
	}

	@GetMapping(path = "/accounts/foruser/{userId}")
	@ApiOperation(value = "getAccountsForUser", nickname = "getAccountsForUser")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Account.class),
			@ApiResponse(code = 500, message = "Failure", response = Account.class) })
	public List<Account> getAccountsForUser(@PathVariable int userId) {
		System.out.println("this will return list of accounts for a user");
		return service.getAccountsByUserId(userId);
	}

	@PostMapping(path = "/accounts/add")
	@ApiOperation(value = "addAccount", nickname = "addAccount")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Account.class),
			@ApiResponse(code = 500, message = "Failure", response = Account.class) })
	public Account addAccount(@RequestBody Account account) {
		System.out.println("this function will add account in database");
		account.setOpeningDate(new Date());
		service.addAccount(account);
		return account;
	}

	@DeleteMapping(path = "/accounts/delete/{accountNo}")
	@ApiOperation(value = "deleteAccount", nickname = "deleteAccount")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Account.class),
			@ApiResponse(code = 500, message = "Failure", response = Account.class) })
	public String deleteAccount(@PathVariable String accountNo) {
		System.out.println("This function will delete account");
		try {
			service.deleteById(accountNo);
		} catch (AccountNotFoundException exc) {
			logger.info(exc.getMessage());
		}
		return "account deleted";
	}

	@PutMapping(path = "/accounts/update")
	@ApiOperation(value = "updateAccount", nickname = "updateAccount")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Account.class),
			@ApiResponse(code = 500, message = "Failure", response = Account.class) })
	public String updateAccount(@RequestBody Account account) {
		System.out.println("This function will update account");
		try {
			service.deleteById(account.getAccountNo());
		} catch (AccountNotFoundException exc) {
			logger.info(exc.getMessage());
		}
		service.addAccount(account);
		return "Account Updated";
	}
	@GetMapping(path = "/accounts/ifaccountexist/{accountNo}")
	@ApiOperation(value = "ifAccountExist", nickname = "checkIfAccountExist")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Account.class),
			@ApiResponse(code = 500, message = "Failure", response = Account.class) })
	public boolean ifAccountExist(@PathVariable String accountNo) {
		if(service.existById(accountNo))
			return true;
		else
			return false;
	}
	
	@PutMapping(path = "/accounts/updatestatus/{status}")
	@ApiOperation(value = "updateAccount", nickname = "updateAccount")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Account.class),
			@ApiResponse(code = 500, message = "Failure", response = Account.class) })
	public Account updateStatusAccount(@PathVariable String status,@RequestBody Account account) throws AccountNotFoundException {
		System.out.println("This function will update account");
		service.deleteById(account.getAccountNo());
		account.setAccountStatus(status);
		service.addAccount(account);
		return account;
	}
}
