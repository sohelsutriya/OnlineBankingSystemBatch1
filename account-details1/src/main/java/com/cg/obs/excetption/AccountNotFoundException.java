/**
 * 
 */
package com.cg.obs.excetption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sohel
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends Exception{

	public AccountNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
