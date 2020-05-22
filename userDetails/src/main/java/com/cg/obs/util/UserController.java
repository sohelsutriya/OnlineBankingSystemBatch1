/**
 * 
 */
package com.cg.obs.util;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.obs.model.User;

/**
 * @author sohel
 *
 */
public class UserController {
	@GetMapping(path = "/user/{userId}")
	public User getUserByUserId(@PathVariable String userId) {
		System.out.println("this will return user by userId");
		return new User();
	}

	@GetMapping(path = "/user/account/{accountNo}")
	public User getUserByAccountNo(@PathVariable String accountNo) {
		System.out.println("this will return user by account no");
		return new User();
	}

	@PostMapping(path = "/user/add")
	public String addUser(@RequestBody User user) {
		System.out.println("this will add user");
		return "user added";
	}
	
	@PutMapping(path = "/user/update")
	public String updateUser(@RequestBody User user) {
		System.out.println("this will update user");
		return "user updated";
	}
	
	@DeleteMapping(path = "/user/delete/{userId}")
	public String deleteUser(@PathVariable String userId) {
		System.out.println("this will delete user");
		return "user deleted";
	}
}
