package com.meritamerica.bankcapstone.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.bankcapstone.models.CDAccount;
import com.meritamerica.bankcapstone.models.CheckingAccount;
import com.meritamerica.bankcapstone.models.DBAAccount;
import com.meritamerica.bankcapstone.models.PersonalCheckingAccount;
import com.meritamerica.bankcapstone.models.RegularIRA;
import com.meritamerica.bankcapstone.models.RolloverIRA;
import com.meritamerica.bankcapstone.models.RothIRA;
import com.meritamerica.bankcapstone.models.SavingsAccount;
import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.services.UserAccountService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserAccountController {

	@Autowired
	UserAccountService service;
	
	// Test APIs =======================================================
	
	@GetMapping(value = "/")
	@ResponseStatus(HttpStatus.OK)
	public String homeTest() {
		return "Homepage!";
	}
	
	@GetMapping(value = "/admin-test")
	@ResponseStatus(HttpStatus.OK)
	public String publicTest() {
		return "Admin test passed.";
	}
	
	@GetMapping(value = "/secured-test")
	@ResponseStatus(HttpStatus.OK)
	public String securedTest() {
		return "Secured test passed.";
	}
	
	// User APIs =======================================================
	
	// Get all users:
	
	@GetMapping(value = "/Users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	// Get user by id:
	
	@GetMapping("/Users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User fetchUserById(@PathVariable("id") String userName) {
		return service.getUserById(userName);
	}
	
	// Post user:
	
	@PostMapping(value = "/Users")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		service.addUser(user);
		return user;
	}
	
	// Delete user:
	
	@DeleteMapping("/Users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<User> removeUserById(@PathVariable("id") Long id) {
		service.removeUserById(id);
		return null;
	}
	
	// Get APIs =======================================================
	
	@GetMapping(value = "/Users/{id}/Checking Account")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccounts(@PathVariable("id") String userName){
		return service.getUserById(userName).getCheckingAccounts();
	}
	
	@GetMapping(value = "/Users/{id}/Savings Account")
	@ResponseStatus(HttpStatus.OK)
	public SavingsAccount getSavingsAccount(@PathVariable("id") String userName){
		return service.getUserById(userName).getSavingsAccount();
	}
	
	
	// Post APIs ======================================================
	
	@PostMapping(value = "/Users/{id}/Checking Account")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount postCheckingAccount(@PathVariable("id") String userName, @RequestBody @Validated CheckingAccount checkingAccount) {
		return service.addCheckingAccount(checkingAccount, userName);
	}
	
	@PostMapping(value = "/Users/{id}/Savings Account")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount postSavingsAccount(@PathVariable("id") String userName, @RequestBody @Validated SavingsAccount savingsAccount) {
		return service.addSavingsAccount(savingsAccount, userName);
	}
	
	@PostMapping(value = "/Users/{id}/Personal Checking Account")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonalCheckingAccount postPersonalCheckingAccount(@PathVariable("id") String userName, @RequestBody @Validated PersonalCheckingAccount personalCheckingAccount) {
		return service.addPersonalCheckingAccount(personalCheckingAccount, userName);
	}
	
	@PostMapping(value = "/Users/{id}/DBA Checking Account")
	@ResponseStatus(HttpStatus.CREATED)
	public DBAAccount postDBAAccount(@PathVariable("id") String userName, @RequestBody @Validated DBAAccount dbaAccount) {
		return service.addDBAAccount(dbaAccount, userName);
	}
	
	@PostMapping(value = "/Users/{id}/Certificate of Deposit Account")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount postCDAccount(@PathVariable("id") String userName, @RequestBody @Validated CDAccount cdAccount) {
		return service.addCDAccount(cdAccount, userName);
	}
	
	@PostMapping(value = "/Users/{id}/Regular IRA")
	@ResponseStatus(HttpStatus.CREATED)
	public RegularIRA postRegularIraAccount(@PathVariable("id") String userName, @RequestBody @Validated RegularIRA regularIra) {
		return service.addRegularIraAccount(regularIra, userName);
	}
	
	@PostMapping(value = "/Users/{id}/Rollover IRA")
	@ResponseStatus(HttpStatus.CREATED)
	public RolloverIRA postRolloverIRA(@PathVariable("id") String userName, @RequestBody @Validated RolloverIRA rolloverIra) {
		return service.addRolloverIraAccount(rolloverIra, userName);
	}
	
	@PostMapping(value = "/Users/{id}/Roth IRA")
	@ResponseStatus(HttpStatus.CREATED)
	public RothIRA postRothIRA(@PathVariable("id") String userName, @RequestBody @Validated RothIRA rothIra) {
		return service.addRothIraAccount(rothIra, userName);
	}
	
		
		

}
