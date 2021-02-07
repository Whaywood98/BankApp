/*
 * Transaction
 * 
 * This class is primarily for logging. It will be added to a list of transactions in a database
 * that shows all deposits and withdrawals to and from accounts.
 * 
 */

package com.meritamerica.bankcapstone.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	// Class attributes:
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String sourceUser;
	private String targetUser;
	private long sourceAccountId;
	private long targetAccountId;
	Date transactionDate = new Date();
	private double amount;
	private String type; 		// Check, cash, ATM, or transfer?
	
	// Constructors:
	
	public Transaction() {
		
	}
	
	public Transaction(String sourceUser, String targetUser, long sourceAccountId, long targetAccountId,
			double amount, String type) {
		this.sourceUser = sourceUser;
		this.targetUser = targetUser;
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.amount = amount;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public String getSourceUser() {
		return sourceUser;
	}

	public void setSourceUser(String sourceUser) {
		this.sourceUser = sourceUser;
	}

	public String getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}

	public long getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(long sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public long getTargetAccountId() {
		return targetAccountId;
	}

	public void setTargetAccountId(long targetAccountId) {
		this.targetAccountId = targetAccountId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void transferFunds() {
		
	}

	// Getters and setters:


	
}
