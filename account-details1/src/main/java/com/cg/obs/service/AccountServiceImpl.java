/**
 * 
 */
package com.cg.obs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.obs.dao.AccountDao;
import com.cg.obs.excetption.AccountNotFoundException;
import com.cg.obs.model.Account;

/**
 * @author sohel
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao dao;

	@Override
	public List<Account> getAccountsByUserId(int userId) {
		return dao.getAccountsByUserId(userId);

	}

	@Override
	public Account findAccountByAccountNo(String accountNo) throws AccountNotFoundException {
		if (existById(accountNo))
			return dao.findById(accountNo).get();
		else
			throw new AccountNotFoundException("Account Does not exist");
	}

	@Override
	public List<Account> findAll() {
		System.out.println(dao.findAll());
		return dao.findAll();
	}

	@Override
	public boolean existById(String accountNo) {
		return dao.existsById(accountNo);
	}

	@Override
	public void addAccount(Account account) {
		if(account!=null)
		dao.save(account);
	}

	@Override
	public void deleteById(String accountNo) throws AccountNotFoundException {
		if (existById(accountNo))
			dao.deleteById(accountNo);
		else
			throw new AccountNotFoundException("Account Does not exist");

	}

	@Override
	public List<Account> findPendingAccounts() {
		return dao.findAll().stream().filter(x -> ("pending".equals(x.getAccountStatus())))
		.collect(Collectors.toList());
	}

}
