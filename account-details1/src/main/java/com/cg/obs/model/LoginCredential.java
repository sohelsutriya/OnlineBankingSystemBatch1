/**
 * 
 */
package com.cg.obs.model;

/**
 * @author sohel
 *
 */
public class LoginCredential {
	private int id;
	private String accountNo;
	private String username;
	private String password;
	private String role;

	public LoginCredential() {
		// TODO Auto-generated constructor stub
	}

	public LoginCredential(int id, String accountNo, String username, String password, String role) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginCredential [id=" + id + ", accountNo=" + accountNo + ", username=" + username + ", password="
				+ password + ", role=" + role + "]";
	}

}
