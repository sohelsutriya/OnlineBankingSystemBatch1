/**
 * 
 */
package com.cg.obs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.obs.model.Account;

/**
 * @author sohel
 *
 */
@Repository
public interface AccountDao extends JpaRepository<Account, String>{
	public List<Account> getAccountsByUserId(int userId);
}
