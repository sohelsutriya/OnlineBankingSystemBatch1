/*
 * 
 * @Author: Simran
 */

package com.cg.obs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.obs.model.User;

@Service
public interface UserService {
	List<User> findAll();
	
	User addUser(User user);
	
	User findByUserId(int userId);

	void deleteUser(int userId);
	
	void updateUser(User user);
	
	User updateMobile(int userId, String mobile);
	
	User updateAddress(int userId,String address);
	
	User findByemail(String email);
}
