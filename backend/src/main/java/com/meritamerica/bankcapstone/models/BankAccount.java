package com.meritamerica.bankcapstone.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force = true)
public abstract class BankAccount {

	// Class attributes:
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double interestRate;
	private double balance;
	@ManyToOne
	private User bankAccountHolder;					// A bank account should only have one user.
	private Date bankAccountOpened = new Date();
	
	// Constructors:
	
	public BankAccount() {
	}

	public BankAccount(double interestRate, double balance) {
		this.interestRate = interestRate;
		this.balance = balance;
		//this.bankAccountHolder = bankAccountHolder;
	}
	
	// Getters and setters:

	public long getId() {
		return id;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getBankAccountHolder() {
		return bankAccountHolder;
	}

	public void setBankAccountHolder(User bankAccountHolder) {
		this.bankAccountHolder = bankAccountHolder;
	}

	public Date getBankAccountOpened() {
		return bankAccountOpened;
	}
	
	// Class methods:
	
	
}
