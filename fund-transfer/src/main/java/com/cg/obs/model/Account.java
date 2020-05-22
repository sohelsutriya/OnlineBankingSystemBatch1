/**
 * 
 */
package com.cg.obs.model;

import java.util.Date;

/**
 * @author sohel
 *
 */
public class Account {
	private String accountNo;
	private String accountType;
	private double balance;
	private String accountStatus;
	private Date openingDate;
	private String userId;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNo, String accountType, double balance, String accountStatus, Date openingDate,
			String userId) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.balance = balance;
		this.accountStatus = accountStatus;
		this.openingDate = openingDate;
		this.userId = userId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", balance=" + balance
				+ ", accountStatus=" + accountStatus + ", openingDate=" + openingDate + ", userId=" + userId + "]";
	}

}
