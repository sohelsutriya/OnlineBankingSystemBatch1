/**
 * @author simran

 */
package com.cg.obs.controller;

import java.util.List;

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

import com.cg.obs.model.User;
import com.cg.obs.service.UserService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
	@Autowired
	public UserService service;

	@GetMapping(path = "/User")
	@ApiOperation(value = "retrieveAllUsers", nickname = "retrieveAllUsers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	public List<User> retrieveAllUsers() {
		System.out.println("Inside retrieveAllUsers method of UserController");
		return service.findAll();
	}

	@PostMapping(path = "/User/add")
	@ApiOperation(value = "addUser", nickname = "addUser")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@GetMapping(path = "/User/{userId}")
	@ApiOperation(value = "retrieveByUserId", nickname = "retrieveByUserId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	User retrieveByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);
	}

	@DeleteMapping(path = "/User/delete/{userId}")
	@ApiOperation(value = "deleteUser", nickname = "deleteUser")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	void deleteUser(@PathVariable("userId") int accNumber) {
		service.deleteUser(accNumber);
	}

	@PutMapping(path = "/User/updatemob/accid/{userId}/mobileno/{mobile}")
	@ApiOperation(value = "updateMobileNo", nickname = "updateMobileNo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	public User updateMobileNo(@PathVariable("userId") int userId, @PathVariable("mobile") String mobile) {
		User user = service.updateMobile(userId, mobile);
		return user;
	}

	@PutMapping(path = "/User/updateaddress/accid/{userId}/address/{address}")
	@ApiOperation(value = "updateAddress", nickname = "updateAddress")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	public User updateAddress(@PathVariable("userId") int userId, @PathVariable("address") String address) {
		User user = service.updateAddress(userId, address);
		return user;
	}

	@PutMapping(path = "/User/update")
	@ApiOperation(value = "updateUser", nickname = "updateUser")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	public String updateUser(@RequestBody User user) {
		service.updateUser(user);
		return "User updated";
	}
	
	//Changes done to work with jwt
	
	@GetMapping(path = "/User/findbyemail/{email}")
	@ApiOperation(value = "retrieveByemail", nickname = "retrieveByemail")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	User retrieveByemail(@PathVariable("email") String email) {
		return service.findByemail(email);
	}

}
