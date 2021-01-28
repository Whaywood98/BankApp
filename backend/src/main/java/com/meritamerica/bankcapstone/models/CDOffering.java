package com.meritamerica.bankcapstone.models;

public class CDOffering {
	
	// Class attributes:
	
	private long id;
	private int term;
	private double interestRate;
	
	// Constructors:
	
	public CDOffering() {
		
	}
	
	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
	
	// Getters and setters:

	public long getId() {
		return id;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	// Class methods:

}
