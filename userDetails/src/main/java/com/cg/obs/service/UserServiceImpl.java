/*
 * 
 * @Author: Simran
 */

package com.cg.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.obs.model.User;
import com.cg.obs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository repos;

	public List<User> findAll() {
		System.out.println("inside findAll method of UserService");
		return repos.findAll();
	}

	public User addUser(@RequestBody User user) {
		System.out.println("inside addUser method of UserService");
		if (user != null) {
			repos.save(user);
			return user;
		} else
			return null;
	}

	public User findByUserId(int userId) {
		System.out.println("inside findByUserId method of UserService");
		return repos.findByUserId(userId);

	}

	public void deleteUser(int accNumber) {
		System.out.println("inside deleteUser method of UserService");
		repos.deleteById(accNumber);

	}

	public User updateMobile(int userId, String mobile) {
		User user = repos.findByUserId(userId);
		user.setMobile(mobile);
		repos.save(user);
		return user;
	}

	public User updateAddress(int userId, String address) {
		User user = repos.findByUserId(userId);
		user.setAddress(address);
		repos.save(user);
		return user;
	}

	@Override
	public void updateUser(User user) {
		repos.deleteById(user.getUserId());
		repos.save(user);

	}
	
	
	//for jwt
	public User findByemail(String email) {
		System.out.println("inside findByemail method of UserService");
		return repos.findByemail(email);

	}

}
