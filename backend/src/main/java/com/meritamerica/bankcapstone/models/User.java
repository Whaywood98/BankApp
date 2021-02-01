package com.meritamerica.bankcapstone.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;



// It is good practice to name the entity.
@Entity(name = "User")
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
	private int dob;
	@Column
	@NotNull
	private int ssn;
	@Column
	@NotNull
	private boolean active;
	private String roles;

	// If sets don't work, use lists instead:
	@OneToMany
	@JoinColumn(name = "UserId")
	private Set<BankAccount> bankAccounts = new HashSet<>();
	/*
	@OneToMany
	private Set<CheckingAccount> checkingAccounts = new HashSet<>(); // Can have multiple.
	@OneToMany
	private Set<SavingsAccount> savingsAccount = new HashSet<>(); // Can only have one.
	@OneToMany
	private Set<PersonalCheckingAccount> personalCheckingAccount = new HashSet<>(); // Can only have one.
	@OneToMany
	private Set<DBAAccount> dbaAccounts = new HashSet<>(); // Can only have 3.
	@OneToMany
	private Set<CDAccount> cdAccounts = new HashSet<>(); // Can have multiple.
	@OneToMany
	private Set<IRAccount> irAccounts = new HashSet<>(); // Can have 1 of each type up to three total.
	*/
	// Constructors:

	// JPA requires an empty constructor:
	public User() {

	}

	public User(String firstName, String middleName, String lastName, String userName, String email, String password, int dob, int ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.ssn = ssn;
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

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", userName=" + userName + ", email=" + email + ", accountOpened=" + accountOpened + ", dob=" + dob
				+ ", ssn=" + ssn + ", active=" + active + "]";
	}

	

}
