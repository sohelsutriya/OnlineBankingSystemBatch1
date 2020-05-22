package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.LoginJpaRepo;
import com.cg.model.LoginCredentials;

@Service
public class LoginService {
	
	@Autowired
	private LoginJpaRepo lrepo;
	
	public LoginCredentials addLoginCredentials(LoginCredentials lc) {
		return lrepo.save(lc);
	}
	
	public List<LoginCredentials> getAllLoginCredentials(){
		return lrepo.findAll();
	}
	

}
