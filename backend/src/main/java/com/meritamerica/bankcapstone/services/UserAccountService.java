package com.meritamerica.bankcapstone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.bankcapstone.models.CDAccount;
import com.meritamerica.bankcapstone.models.CDOffering;
import com.meritamerica.bankcapstone.models.CheckingAccount;
import com.meritamerica.bankcapstone.models.DBAAccount;
import com.meritamerica.bankcapstone.models.RegularIRA;
import com.meritamerica.bankcapstone.models.RolloverIRA;
import com.meritamerica.bankcapstone.models.RothIRA;
import com.meritamerica.bankcapstone.models.SavingsAccount;
import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.repositories.CDAccountRepository;
import com.meritamerica.bankcapstone.repositories.CDOfferingRepository;
import com.meritamerica.bankcapstone.repositories.CheckingAccountRepository;
import com.meritamerica.bankcapstone.repositories.DBARepository;
import com.meritamerica.bankcapstone.repositories.PersonalCheckingAccountRepository;
import com.meritamerica.bankcapstone.repositories.RegularIRARepository;
import com.meritamerica.bankcapstone.repositories.RolloverIRARepository;
import com.meritamerica.bankcapstone.repositories.RothIRARepository;
import com.meritamerica.bankcapstone.repositories.SavingsAccountRepository;
import com.meritamerica.bankcapstone.repositories.UserRepository;

@Service
public class UserAccountService {

	// Repositories:
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SavingsAccountRepository savingsAccountRepository;
	
	@Autowired
	RothIRARepository rothIRARepository;
	
	@Autowired
	RolloverIRARepository rolloverIRARepository;
	
	@Autowired
	RegularIRARepository regularIRARepository;
	
	@Autowired
	PersonalCheckingAccountRepository personalCheckingAccountRepository;
	
	@Autowired
	DBARepository dbaRepository;
	
	@Autowired
	CheckingAccountRepository checkingAccountRepository;
	
	@Autowired
	CDOfferingRepository cdOfferingRepository;
	
	@Autowired
	CDAccountRepository cdAccountRepository;
	
	// User methods:
	
	// Add a new user. Admin only.
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	// Get a list of all users. Admin Only.
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	// Search for user by id:
	public Optional<User> getUserById(long id) {
		return userRepository.findById(id);
	}
	
	// Remove user by id:
	public void removeUserById(long id) {
		userRepository.deleteById(id);
	}
	
	// Savings account methods:
	
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount, long id) {
		return savingsAccountRepository.save(savingsAccount);
	}
	
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsAccountRepository.findAll();
	}
	
	public Optional<SavingsAccount> getSavingsAccountById(long id) {
		return savingsAccountRepository.findById(id);
	}
	
	public void removeSavingsAccountById(long id) {
		savingsAccountRepository.deleteById(id);
	}
	
	// Checking account methods:
	
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount, long id) {
		return checkingAccountRepository.save(checkingAccount);
	}
	
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingAccountRepository.findAll();
	}
	
	public Optional<CheckingAccount> getCheckingAccountById(long id) {
		return checkingAccountRepository.findById(id);
	}
	
	public void removeCheckingAccountById(long id) {
		checkingAccountRepository.deleteById(id);
	}
	
	// CD Account methods:
	
	public CDAccount addCDAccount(CDAccount cdAccount, long id) {
		return cdAccountRepository.save(cdAccount);
	}
	
	public List<CDAccount> getCDAccounts(){
		return cdAccountRepository.findAll();
	}
	
	public Optional<CDAccount> getCDAccountById(long id) {
		return cdAccountRepository.findById(id);
	}
	
	public void removeCDAccountById(long id) {
		cdAccountRepository.deleteById(id);
	}
	
	// CD Offering methods:
	
	public CDOffering addCDOffering(CDOffering cdOffering, long id) {
		return cdOfferingRepository.save(cdOffering);
	}
	
	public List<CDOffering> getCDOfferings(){
		return cdOfferingRepository.findAll();
	}
	
	public Optional<CDOffering> getCDOfferingsById(long id) {
		return cdOfferingRepository.findById(id);
	}
	
	public void removeCDOfferingById(long id) {
		cdOfferingRepository.deleteById(id);
	}
	
	// DBA Account methods:
	
	public DBAAccount addDBAAccount(DBAAccount dbaAccount, long id) {
		return dbaRepository.save(dbaAccount);
	}
	
	public List<DBAAccount> getDBAAccount(){
		return dbaRepository.findAll();
	}
	
	public Optional<DBAAccount> getDBAAccountById(long id) {
		return dbaRepository.findById(id);
	}
	
	public void removeDBAAccountById(long id) {
		dbaRepository.deleteById(id);
	}
	
	// RegularIRAccount methods:
	
	public RegularIRA addRegularIRAccount(RegularIRA irAccount, long id) {
		return regularIRARepository.save(irAccount);
	}
	
	public List<RegularIRA> getRegularIRAccount(){
		return regularIRARepository.findAll();
	}
	
	public Optional<RegularIRA> getRegularIRAccountById(long id) {
		return regularIRARepository.findById(id);
	}
	
	public void removeRegularIRAccountById(long id) {
		regularIRARepository.deleteById(id);
	}
	
	// RolloverIRAccount methods:
	
	public RolloverIRA addRolloverIRAccount(RolloverIRA irAccount, long id) {
		return rolloverIRARepository.save(irAccount);
	}
	
	public List<RolloverIRA> getRolloverIRAccount(){
		return rolloverIRARepository.findAll();
	}
	
	public Optional<RolloverIRA> getRolloverIRAccountById(long id) {
		return rolloverIRARepository.findById(id);
	}
	
	public void removeRolloverIRAccountById(long id) {
		rolloverIRARepository.deleteById(id);
	}
	
	// RothIRAccount methods:
	
	public RothIRA addRothIRAccount(RothIRA irAccount, long id) {
		return rothIRARepository.save(irAccount);
	}
	
	public List<RothIRA> getRothIRAccount(){
		return rothIRARepository.findAll();
	}
	
	public Optional<RothIRA> getRothIRAccountById(long id) {
		return rothIRARepository.findById(id);
	}
	
	public void removeRothIRAccountById(long id) {
		rothIRARepository.deleteById(id);
	}
}
