/**
 * 
 */
package com.cg.obs.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cg.obs.model.Transaction;

/**
 * @author sohel
 *
 */
@Service
public interface TransactionService extends JpaRepository<Transaction, Integer>{
	
}
