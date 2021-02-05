/*
 * Transaction
 * 
 * This class is primarily for logging. It will be added to a list of transactions in a database
 * that shows all deposits and withdrawals to and from accounts.
 * 
 */

package com.meritamerica.bankcapstone.models;

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
	private String targetAccountId;
	private String sourceAccountId;
	private double amount;
	private String type; 		// Check, cash, ATM, or transfer?
	
	// Constructors:
	
	public Transaction() {
		
	}

	public Transaction(String targetAccountId, String sourceAccountId, double amount, String type) {
		this.targetAccountId = targetAccountId;
		this.sourceAccountId = sourceAccountId;
		this.amount = amount;
		this.type = type;
	}
	
	// Getters and setters:

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTargetAccountId() {
		return targetAccountId;
	}

	public void setTargetAccountId(String targetAccountId) {
		this.targetAccountId = targetAccountId;
	}

	public String getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(String sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
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
	
}
