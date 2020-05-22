package com.cg.obs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.obs.model.User;
import com.cg.obs.repository.UserRepository;
import com.cg.obs.service.UserServiceImpl;

@SpringBootTest
class UserDetailsApplicationTests {
	
	@InjectMocks
	UserServiceImpl service;
	
	@Mock
	UserRepository dao;

	@Test
	void findAll() {
		
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "MS", "Dhoni", "9876567908", "Ranchi", "XXXXX22313P", "mahi@mail.com"));
		list.add(new User(2, "Virat", "Kohli", "9872346208", "Delhi", "AGJAX22313P", "chiku@mail.com"));
		list.add(new User(3, "Rohit", "Sharma", "9868796872", "Mumbai", "JFHAX22323L", "hitman@mail.com"));
		list.add(new User(4, "Shikhar", "Dhawan", "9868796822", "Delhi", "ZMBAX25154L", "gabbar@mail.com"));
		
		when(dao.findAll()).thenReturn(list);
		
		List<User> servlist = service.findAll();
		
		assertEquals(4,servlist.size());

	}
	
	@Test
	void userAddedSuccessfully() {
		
		when(dao.save(new User(1, "MS", "Dhoni", "9876567908", "Ranchi", "XXXXX22313P", "mahi@mail.com"))).thenReturn(new User(1, "MS", "Dhoni", "9876567908", "Ranchi", "XXXXX22313P", "mahi@mail.com"));
		
		User user = service.addUser(new User(1, "MS", "Dhoni", "9876567908", "Ranchi", "XXXXX22313P", "mahi@mail.com"));
		
		assertEquals("MS",user.getFname());
		assertEquals("Dhoni",user.getLname());
		assertEquals("9876567908",user.getMobile());
		assertEquals("Ranchi",user.getAddress());
		assertEquals("XXXXX22313P",user.getPan());

	}
	
	@Test
	void userAddByNull() {
		
		when(dao.save(null)).thenReturn(null);
		assertEquals(null,service.addUser(null));

	}
	
	@Test
	void findById() {
		
		when(dao.findByUserId(1)).thenReturn(new User(1, "MS", "Dhoni", "9876567908", "Ranchi", "XXXXX22313P", "mahi@mail.com"));
		
		User user = service.findByUserId(1);
		
		assertEquals("MS",user.getFname());
		assertEquals("Dhoni",user.getLname());
		assertEquals("9876567908",user.getMobile());
		assertEquals("Ranchi",user.getAddress());
		assertEquals("XXXXX22313P",user.getPan());
	}
	
	@Test
	void findByEmail() {
		
		when(dao.findByemail("mahi@mail.com")).thenReturn(new User(1, "MS", "Dhoni", "9876567908", "Ranchi", "XXXXX22313P", "mahi@mail.com"));
		
		User user = service.findByemail("mahi@mail.com");
		
		assertEquals("MS",user.getFname());
		assertEquals("Dhoni",user.getLname());
		assertEquals("9876567908",user.getMobile());
		assertEquals("Ranchi",user.getAddress());
		assertEquals("XXXXX22313P",user.getPan());
	}
	
	@Test
	void UpdateMobile() {
		
		when(dao.findByUserId(1)).thenReturn(new User(1, "MS", "Dhoni", "9876567908", "Ranchi", "XXXXX22313P", "mahi@mail.com"));
		
		User user = service.updateMobile(1, "9876543210");
		
		assertEquals("9876543210",user.getMobile());
		
	}
	
	@Test
	void UpdateAddress() {
		
		when(dao.findByUserId(1)).thenReturn(new User(1, "MS", "Dhoni", "9876567908", "Ranchi", "XXXXX22313P", "mahi@mail.com"));
		
		User user = service.updateAddress(1, "India");
		
		assertEquals("India",user.getAddress());
		
	}

}
