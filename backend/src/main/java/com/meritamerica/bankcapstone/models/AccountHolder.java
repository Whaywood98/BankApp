package com.meritamerica.bankcapstone.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class AccountHolder {

	// Class attributes:
	
	//@Id
	//@Column
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private User user;
	// If sets don't work, use lists instead:
	private Set<CheckingAccount> checkingAccounts = new HashSet<>();					// Can have multiple.
	private Set<SavingsAccount> savingsAccount = new HashSet<>();						// Can only have one.
	private Set<PersonalCheckingAccount> personalCheckingAccount = new HashSet<>();		// Can only have one.
	private Set<DBAAccount> dbaAccounts = new HashSet<>(); 								// Can only have 3.
	private Set<CDAccount> cdAccounts = new HashSet<>();								// Can have multiple.
	private Set<IRAccount> irAccounts = new HashSet<>();								// Can have 1 of each type up to three total.
	
	// Constructors:
	
	public AccountHolder() {
		
	}
	
	public AccountHolder(User user) {
		this.user = user;
	}
	
	// Getters and setters:

	public long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}

	public void setCheckingAccounts(Set<CheckingAccount> checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
	}

	public Set<SavingsAccount> getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(Set<SavingsAccount> savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	public Set<PersonalCheckingAccount> getPersonalCheckingAccount() {
		return personalCheckingAccount;
	}

	public void setPersonalCheckingAccount(Set<PersonalCheckingAccount> personalCheckingAccount) {
		this.personalCheckingAccount = personalCheckingAccount;
	}

	public Set<DBAAccount> getDbaAccounts() {
		return dbaAccounts;
	}

	public void setDbaAccounts(Set<DBAAccount> dbaAccounts) {
		this.dbaAccounts = dbaAccounts;
	}

	public Set<CDAccount> getCdAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(Set<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}

	public Set<IRAccount> getIrAccounts() {
		return irAccounts;
	}

	public void setIrAccounts(Set<IRAccount> irAccounts) {
		this.irAccounts = irAccounts;
	}
	
	
	// Class methods:
	
	
}
