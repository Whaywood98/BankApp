/*
 * CDAccount - Certificate of Deposit
 */

package com.meritamerica.bankcapstone.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("CD")
public class CDAccount extends BankAccount {
	
	// Class attributes:
	
	private int term;
	
	// Constructors:

	public CDAccount() {
	}
	
	// Getters and setters:
	
	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
	
	// Class methods:

}
