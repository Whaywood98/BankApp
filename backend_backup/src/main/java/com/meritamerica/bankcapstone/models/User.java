package com.meritamerica.bankcapstone.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class User {

	// Class attributes:

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	@NotNull
	private String firstName;
	@Column
	@NotNull
	private String middleName;
	@Column
	@NotNull
	private String lastName;
	@Column
	@NotNull
	private String userName;
	@Column
	@NotNull
	private String email;
	@Column
	@NotNull
	private String password;
	@Column
	@NotNull
	private Date accountOpened = new Date();
	@Column
	@NotNull
	private Date dob;
	@Column
	@NotNull
	private int ssn;
	@Column
	@NotNull
	private boolean active = true;
	@Column
	@NotNull
	private String roles = "USER"; // Initialize to user since I only want one admin account.

	@OneToMany(cascade = CascadeType.ALL)
	private List<BankAccount> bankAccounts = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<IRAccount> irAccounts = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<CDOffering> cdOfferings = new ArrayList<>();
	
	/*
	 * @OneToMany private List<CheckingAccount> checkingAccounts = new
	 * ArrayList<>(); // Can have multiple.
	 * 
	 * @OneToMany private List<DBAAccount> dbaAccounts = new ArrayList<>(); // Can
	 * only have 3.
	 * 
	 * @OneToMany private List<CDAccount> cdAccounts = new ArrayList<>(); // Can
	 * have multiple.
	 * 
	 * @OneToOne private SavingsAccount savingsAccounts; // Can only have one.
	 * 
	 * @OneToOne private PersonalCheckingAccount personalCheckingAccount; // Can
	 * only have one.
	 * 
	 * @OneToOne private RegularIRA regularIra;
	 * 
	 * @OneToOne private RolloverIRA rolloverIra;
	 * 
	 * @OneToOne private RothIRA rothIra;
	 * 
	 */

	// Constructors:

	// JPA requires an empty constructor:
	public User() {

	}

	public User(String firstName, String middleName, String lastName, String userName, String password, String roles,
			String email, Date dob, int ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.dob = dob;
		this.ssn = ssn;
		this.password = password;
		this.roles = roles;
	}

	// Getters and setters:

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAccountOpened() {
		return accountOpened;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	// These return specific accounts from the bank account list:
	
	public List<BankAccount> getCheckingAccounts() {
		List<BankAccount> accounts = new ArrayList<>();
		for (BankAccount account : this.bankAccounts) {
			if (account instanceof CheckingAccount && account.isActive()) {
				accounts.add(account);
			}
		}
		return accounts;
	}

	public BankAccount getSavingsAccount() {
		List<BankAccount> accounts = new ArrayList<>();
		for (BankAccount account : this.bankAccounts) {
			if (account instanceof SavingsAccount && account.isActive()) {
				accounts.add(account);
			}
		}
		return accounts.get(0);
	}

	public BankAccount getPersonalCheckingAccount() {
		List<BankAccount> accounts = new ArrayList<>();
		for (BankAccount account : this.bankAccounts) {
			if (account instanceof PersonalCheckingAccount && account.isActive()) {
				accounts.add(account);
			}
		}
		return accounts.get(0);
	}

	public List<BankAccount> getDBAAccounts() {
		List<BankAccount> accounts = new ArrayList<>();
		for (BankAccount account : this.bankAccounts) {
			if (account instanceof DBAAccount && account.isActive()) {
				accounts.add(account);
			}
		}
		return accounts;
	}

	public List<BankAccount> getCDAccounts() {
		List<BankAccount> accounts = new ArrayList<>();
		for (BankAccount account : this.bankAccounts) {
			if (account instanceof CDAccount && account.isActive()) {
				accounts.add(account);
			}
		}
		return accounts;
	}
	
	// These add accounts to the BankAccount list:
	
	public void addSavingsAccount(SavingsAccount account) {
		this.bankAccounts.add(account);
	}
	
	public void addCheckingAccount(CheckingAccount account) {
		this.bankAccounts.add(account);
	}
	
	public void addCdAccount(CDAccount account) {
		 this.bankAccounts.add(account); 
	}
	
	public void addDbaAccount(DBAAccount account) {
		this.bankAccounts.add(account);
	}
	
	public void addPersonalCheckingAccount(PersonalCheckingAccount account) {
		this.bankAccounts.add(account);
	}
	
// These return IRAccounts from the IRAccount list:
	
	public IRAccount getRegularIRAccount() {
		List<IRAccount> accounts = new ArrayList<>();
		for (IRAccount account : this.irAccounts) {
			if (account instanceof RegularIRA && account.isActive()) {
				accounts.add(account);
			}
		}
		return accounts.get(0);
	}
	
	public IRAccount getRothIRAccount() {
		List<IRAccount> accounts = new ArrayList<>();
		for (IRAccount account : this.irAccounts) {
			if (account instanceof RothIRA && account.isActive()) {
				accounts.add(account);
			}
		}
		return accounts.get(0);
	}
	
	public IRAccount getRolloverIRAccount() {
		List<IRAccount> accounts = new ArrayList<>();
		for (IRAccount account : this.irAccounts) {
			if (account instanceof RolloverIRA && account.isActive()) {
				accounts.add(account);
			}
		}
		return accounts.get(0);
	}
	
	// These add IRAccounts to the irAccounts list:
	
	public void addRegularIRAccount(RegularIRA account) {
		this.irAccounts.add(account);
	}
	
	public void addRothIRAccount(RothIRA account) {
		this.irAccounts.add(account);
	}
	
	public void addRolloverIRAccount(RolloverIRA account) {
		this.irAccounts.add(account);
	}
	
	// ======================================================

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}

	// Hashcode, toString, and equals methods:

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
