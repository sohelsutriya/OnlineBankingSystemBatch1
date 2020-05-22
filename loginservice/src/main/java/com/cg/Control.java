package com.cg;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.LoginCredentials;
import com.cg.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class Control {
	
	@Autowired
	private LoginService service;
	
	@PostMapping("/Login")
	public LoginCredentials login(@RequestBody LoginCredentials user) {
		
		List<LoginCredentials> list_lc = service.getAllLoginCredentials().stream().filter(l -> l.getUsername().equals(user.getUsername())).collect(Collectors.toList());
		LoginCredentials lc;
		if(!list_lc.isEmpty()) {
			lc = list_lc.get(0);
			System.out.println(lc.getUsername()+lc.getUserId()+lc.getPassword());
			System.out.println(user.getUsername()+user.getUserId()+user.getPassword());
			if(lc.getPassword().equals(user.getPassword())) {
				return lc;
			}
			else
				return null;
		}
		else
			return null;
		
	}
	@PostMapping("/AddLogin")
	public void addLoginDetails(@RequestBody LoginCredentials lc) {
		
		service.addLoginCredentials(lc);
		
	}
	
	@GetMapping("/getAllLoginCredentials")
	public List<LoginCredentials> getAllLoginCredentials(){
		return service.getAllLoginCredentials();
	}
}
