/**
 * 
 */
package com.cg.obs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sohel
 *
 */
@Entity
@Table(name = "Account")
public class Account {
	@Id
	private String accountNo;
	@Column
	private String accountType;
	@Column
	private double balance;
	@Column
	private String accountStatus;
	@Column
	private Date openingDate;
	@Column
	private int userId;

	public Account() {
		// TODO Auto-generated constructor stub
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Account(String accountNo, String accountType, double balance, String accountStatus, Date openingDate,
			int userId) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.balance = balance;
		this.accountStatus = accountStatus;
		this.openingDate = openingDate;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", balance=" + balance
				+ ", accountStatus=" + accountStatus + ", openingDate=" + openingDate + ", userId=" + userId + "]";
	}

	

}
