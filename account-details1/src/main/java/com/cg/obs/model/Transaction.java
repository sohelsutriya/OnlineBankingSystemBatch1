/**
 * 
 */
package com.cg.obs.model;

import java.util.Date;

/**
 * @author sohel
 *
 */
public class Transaction {
	private String transactionId;
	private String transactionType;
	private Date transactionDate;
	private double amount;
	private String accountNo;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String transactionId, String transactionType, Date transactionDate, double amount,
			String accountNo) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.accountNo = accountNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + ", accountNo=" + accountNo + "]";
	}

}
