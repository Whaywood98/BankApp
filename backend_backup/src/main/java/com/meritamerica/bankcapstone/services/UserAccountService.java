package com.meritamerica.bankcapstone.services;


import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.meritamerica.bankcapstone.models.BankAccount;
import com.meritamerica.bankcapstone.models.CDAccount;
import com.meritamerica.bankcapstone.models.CDOffering;
import com.meritamerica.bankcapstone.models.CheckingAccount;
import com.meritamerica.bankcapstone.models.DBAAccount;
import com.meritamerica.bankcapstone.models.IRAccount;
import com.meritamerica.bankcapstone.models.PersonalCheckingAccount;
import com.meritamerica.bankcapstone.models.RegularIRA;
import com.meritamerica.bankcapstone.models.RolloverIRA;
import com.meritamerica.bankcapstone.models.RothIRA;
import com.meritamerica.bankcapstone.models.SavingsAccount;
import com.meritamerica.bankcapstone.models.Transaction;
import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.repositories.BankAccountRepository;
import com.meritamerica.bankcapstone.repositories.CDOfferingRepository;
import com.meritamerica.bankcapstone.repositories.IRARepository;
import com.meritamerica.bankcapstone.repositories.TransactionRepository;
import com.meritamerica.bankcapstone.repositories.UserRepository;

@Service
public class UserAccountService {

	// Repositories:
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	BankAccountRepository bankAccountRepository;
	
	@Autowired
	IRARepository iraRepository;
	
	@Autowired
	CDOfferingRepository cdoRepository;
	
	PasswordEncoder passwordEncoder;
	
	// Constructor:
	
	public UserAccountService() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	// Bank account methods:
	
	public BankAccount getBankAccountById(long id) {
		return bankAccountRepository.findBankAccountById(id);
	}
	
	// User methods:
	
	public User addUser(User user) {
		String encodedPassword = this.passwordEncoder.encode(user.getPassword()); // Before saving, we encode the password!
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User getUserByName(String userName) {
		System.out.println("Searching for user: " + userName + ", and found: " + userRepository.findUserById(userName));
		return userRepository.findUserById(userName);
	}
	
	public void removeUserById(long id) {
		userRepository.deleteById(id);
	}
	
	// Savings account methods:
	
	public BankAccount getSavingsAccount(String userName) {
		return getUserByName(userName).getSavingsAccount();
	}
	
	public Optional<BankAccount> getSavingsAccountById(long id) {
		return bankAccountRepository.findById(id);
	}
	
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount, String userName) {
		getUserByName(userName).addSavingsAccount(savingsAccount);
		bankAccountRepository.save(savingsAccount);
		return savingsAccount;
	}
	
	public Boolean removeSavingsAccountById(long id) {
		try {
			bankAccountRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return true;
		}
	}
	

	// Checking account methods:
	
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount, String userName) {
		getUserByName(userName).addCheckingAccount(checkingAccount);
		bankAccountRepository.save(checkingAccount);
		return checkingAccount;
	}
	
	public List<BankAccount> getCheckingAccounts(String userName){
		return getUserByName(userName).getCheckingAccounts();
	}
	
	public Optional<BankAccount> getCheckingAccountById(long id) {
		return bankAccountRepository.findById(id);
	}
	
	public boolean removeCheckingAccountById(long id) {
		try {
			bankAccountRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return true;
		}
	}
	
	// CD Account methods:
	
	public CDAccount addCDAccount(CDAccount cdAccount, String userName) {
		getUserByName(userName).addCdAccount(cdAccount);
		bankAccountRepository.save(cdAccount);
		return cdAccount;
	}
	
	public List<BankAccount> getCDAccounts(String userName){
		return getUserByName(userName).getCDAccounts();
	}
	
	public Optional<BankAccount> getCDAccountById(long id) {
		return bankAccountRepository.findById(id);
	}
	
	public boolean removeCDAccountById(long id) {
		try {
			bankAccountRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return true;
		}
	}
	
	// DBA Account methods:

	public DBAAccount addDBAAccount(DBAAccount dbaAccount, String userName) {
		getUserByName(userName).addDbaAccount(dbaAccount);
		bankAccountRepository.save(dbaAccount);
		return dbaAccount;
	}
	
	public List<BankAccount> getDBAAccounts(String userName){
		return getUserByName(userName).getDBAAccounts();
	}
	
	public Optional<BankAccount> getDBAAccountById(long id) {
		return bankAccountRepository.findById(id);
	}
	
	public boolean removeDBAAccountById(long id) {
		try {
			bankAccountRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return true;
		}
	}
	
	// Personal Checking Account methods:
	
	public PersonalCheckingAccount addPersonalCheckingAccount(PersonalCheckingAccount account, String userName) {
		getUserByName(userName).addPersonalCheckingAccount(account);
		bankAccountRepository.save(account);
		return account;
	}
	
	public BankAccount getPersonalCheckingAccount(String userName){
		return getUserByName(userName).getPersonalCheckingAccount();
	}
	
	public Optional<BankAccount> getPersonalCheckingAccountById(long id) {
		return bankAccountRepository.findById(id);
	}
	
	public boolean removePersonalCheckingAccountById(long id) {
		try {
			bankAccountRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return true;
		}
	}
	
	// Regular IR Account methods:
	
	public RegularIRA addRegularIRAccount(RegularIRA account, String userName) {
		getUserByName(userName).addRegularIRAccount(account);
		iraRepository.save(account);
		return account;
	}
	
	public IRAccount getRegularIRA(String userName){
		return getUserByName(userName).getRegularIRAccount();
	}
	
	public Optional<IRAccount> getRegularIRAccountById(long id) {
		return iraRepository.findById(id);
	}
	
	public boolean removeRegularIRAccountById(long id) {
		try {
			iraRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return true;
		}
	}
	
	// Roth IR Account methods:
	
	public RothIRA addRothIRAccount(RothIRA account, String userName) {
		getUserByName(userName).addRothIRAccount(account);
		iraRepository.save(account);
		return account;
	}
	
	public IRAccount getRothIRA(String userName){
		return getUserByName(userName).getRothIRAccount();
	}
	
	public Optional<IRAccount> getRothIRAccountById(long id) {
		return iraRepository.findById(id);
	}
	
	public boolean removeRothIRAccountById(long id) {
		try {
			iraRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return true;
		}
	}
	
	// Rollover IR Account methods:
	
	public RolloverIRA addRolloverIRAccount(RolloverIRA account, String userName) {
		getUserByName(userName).addRolloverIRAccount(account);
		iraRepository.save(account);
		return account;
	}
	
	public IRAccount getRolloverIRA(String userName){
		return getUserByName(userName).getRolloverIRAccount();
	}
	
	public Optional<IRAccount> getRolloverIRAccountById(long id) {
		return iraRepository.findById(id);
	}
	
	public boolean removeRolloverIRAccountById(long id) {
		try {
			iraRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return true;
		}
	}
	
	// CD Offering methods:
	
	public CDOffering addCDOffering(CDOffering cdOffering, long id) {
		return cdoRepository.save(cdOffering);
	}
	
	public List<CDOffering> getCDOfferings(){
		return cdoRepository.findAll();
	}
	
	public Optional<CDOffering> getCDOfferingsById(long id) {
		return cdoRepository.findById(id);
	}
	
	public void removeCDOfferingById(long id) {
		cdoRepository.deleteById(id);
	}
	
	// Transaction methods
	
	public Transaction addTransaction(Transaction transaction, String userName) {
		getUserByName(userName).addTransaction(transaction);
		transactionRepository.save(transaction);
		
		// Processing transaction:
		// Re-add additional logic here:
		BankAccount sourceAccount = getBankAccountById(transaction.getSourceAccountId());
		BankAccount targetAccount = getBankAccountById(transaction.getTargetAccountId());
		
		sourceAccount.setBalance(sourceAccount.getBalance() - transaction.getAmount());
		targetAccount.setBalance(targetAccount.getBalance() + transaction.getAmount());
		
		return transaction;
	}

	public List<Transaction> getTransactions(){
		return transactionRepository.findAll();
	}
	
	public List<Transaction> getTransactionsByUser(String user){
		return getUserByName(user).getTransactions();
	}

	public Optional<Transaction> getTransactionById(long id) {
		return transactionRepository.findById(id);
	}

	public void removeTransactionById(long id) {
		transactionRepository.deleteById(id);
	}
}
