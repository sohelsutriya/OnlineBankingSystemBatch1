package com.cg.obs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.obs.dao.AccountDao;
import com.cg.obs.model.Account;
import com.cg.obs.service.AccountServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class AccountDetails1ApplicationTests {
	
	@InjectMocks
	AccountServiceImpl accServ;
	
	@Mock
	AccountDao dao;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	void contextLoads() {
		assertTrue(accServ.findAll().isEmpty());
	}
	
	@Test
	void findAllAccounts() {
		List<Account> accList = new ArrayList<Account>();
		accList.add(new Account("405678", "savings", 50000.0, "pending", new Date(),3));
		accList.add(new Account("324256", "current", 1000000.0, "pending", new Date(),3));
		accList.add(new Account("746245", "savings", 99000.0, "pending", new Date(),3));
		
		when(dao.findAll()).thenReturn(accList);
		
		List<Account> servList = accServ.findAll();
		
		assertEquals(3,servList.size());
		verify(dao, times(2)).findAll();
	}
	
	@Test
	void findAccountByAccountId() {
		
		when(dao.getAccountsByUserId(9)).thenReturn(Stream.of(new Account("405678", "savings", 50000.0, "pending", new Date(),9)).collect(Collectors.toList()));
		
		Account acc = accServ.getAccountsByUserId(9).get(0);
		
		assertEquals("405678",acc.getAccountNo());
		assertEquals("savings",acc.getAccountType());
		assertEquals(50000.0,acc.getBalance(),1e-15);
		assertEquals("pending",acc.getAccountStatus());
	}
	
	@Test
	void existByIdTrue() {
		
		when(dao.existsById("111111")).thenReturn(true);
		
		assertTrue(accServ.existById("111111"));
	}
	
	@Test
	void existByIdFalse() {
		
		when(dao.existsById("21212121")).thenReturn(false);
		
		assertFalse(accServ.existById("21212121"));
	}
	
	@Test
	void findPending() {
		List<Account> accList = new ArrayList<Account>();
		accList.add(new Account("405678", "savings", 50000.0, "pending", new Date(),3));
		accList.add(new Account("324256", "current", 1000000.0, "approved", new Date(),3));
		accList.add(new Account("746245", "savings", 99000.0, "pending", new Date(),3));
		
		when(dao.findAll()).thenReturn(accList);
		
		List<Account> pendingList = accServ.findPendingAccounts();
		
		assertEquals(2,pendingList.size());
	}
	

}
