/**
 * 
 */
package com.cg.obs.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cg.obs.excetption.AccountNotFoundException;
import com.cg.obs.model.Account;

/**
 * @author sohel
 *
 */
@Service
public interface AccountService {
	public List<Account> getAccountsByUserId(int userId);

	public Account findAccountByAccountNo(String accountNo) throws AccountNotFoundException;

	public List<Account> findAll();
	
	public List<Account> findPendingAccounts();

	public boolean existById(String accountNo);

	public void addAccount(Account account);

	public void deleteById(String accountNo) throws AccountNotFoundException;

}
