package com.meritamerica.bankcapstone.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.bankcapstone.models.BankAccount;
import com.meritamerica.bankcapstone.models.CDAccount;
import com.meritamerica.bankcapstone.models.CheckingAccount;
import com.meritamerica.bankcapstone.models.DBAAccount;
import com.meritamerica.bankcapstone.models.IRAccount;
import com.meritamerica.bankcapstone.models.JwtRequest;
import com.meritamerica.bankcapstone.models.JwtResponse;
import com.meritamerica.bankcapstone.models.PersonalCheckingAccount;
import com.meritamerica.bankcapstone.models.RegularIRA;
import com.meritamerica.bankcapstone.models.RolloverIRA;
import com.meritamerica.bankcapstone.models.RothIRA;
import com.meritamerica.bankcapstone.models.SavingsAccount;
import com.meritamerica.bankcapstone.models.Transaction;
import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.services.MyUserDetailsService;
import com.meritamerica.bankcapstone.services.UserAccountService;
import com.meritamerica.bankcapstone.utility.JWTUtility;

//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:31337"})
@CrossOrigin
@RestController
public class UserAccountController {

	@Autowired
	UserAccountService service;

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	// Test APIs =======================================================

	@GetMapping(value = "/home")
	@ResponseStatus(HttpStatus.OK)
	public String homeTest() {
		return "Homepage!";
	}

	@GetMapping(value = "/admin-test")
	@ResponseStatus(HttpStatus.OK)
	public String publicTest() {
		return "Admin test passed.";
	}

	@GetMapping(value = "/user-test")
	@ResponseStatus(HttpStatus.OK)
	public String securedTest() {
		return "User test passed.";
	}

	@PostMapping(value = "/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

		// Debugging:
		System.out.println("=============================");
		System.out.println("Authentication requested by:");
		System.out.println(jwtRequest.getUserName());
		System.out.println("Using password:");
		System.out.println(jwtRequest.getPassword());
		System.out.println("=============================");
		// /Debugging

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid credentials.", e);
		}

		// Now that authentication is done, let's create a token. First, get the user
		// details:

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(jwtRequest.getUserName());

		// Now we generate a token using the user details as a parameter:

		final String token = jwtUtility.generateToken(userDetails);

		// Return the token in a JwtResponse:

		return new JwtResponse(token);
	}

	// User APIs =======================================================

	// Get all users:
	@GetMapping(value = "/api/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers() {
		return service.getUsers();
	}

	// Get user by userName:
	@GetMapping("/api/users/{user}")
	@ResponseStatus(HttpStatus.OK)
	public User fetchUserById(@PathVariable("user") String userName) {
		return service.getUserByName(userName);
	}

	// Post user:
	@PostMapping(value = "/api/users")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		service.addUser(user);
		return user;
	}

	// Delete user:
	@DeleteMapping("/api/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<User> removeUserById(@PathVariable("id") Long id) {
		service.removeUserById(id);
		return null;
	}

	// Savings Account APIs =======================================================

	@GetMapping(value = "/api/users/{id}/savings-account")
	@ResponseStatus(HttpStatus.OK)
	public BankAccount getSavingsAccount(@PathVariable("id") String userName) {
		return service.getSavingsAccount(userName);
	}
	
	@GetMapping(value = "/api/users/{id}/savings-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<BankAccount> getSavingsAccountById(@PathVariable("id") String userName, @PathVariable("aid") long id) {
		return service.getSavingsAccountById(id);
	}

	@PostMapping(value = "/api/users/{id}/savings-account")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount postSavingsAccount(@PathVariable("id") String userName,
			@RequestBody SavingsAccount account) {
		return service.addSavingsAccount(account, userName);
	}
	
	@DeleteMapping(value = "/api/users/{id}/savings-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Boolean deleteSavingsAccount(@PathVariable("id") String userName, @PathVariable("aid") long aid) {
		return service.removeSavingsAccountById(aid);
	}

	// Checking Account APIs ======================================================

	@GetMapping(value = "/api/users/{id}/checking-account")
	@ResponseStatus(HttpStatus.OK)
	public List<BankAccount> getCheckingAccounts(@PathVariable("id") String userName) {
		return service.getCheckingAccounts(userName);
	}
	
	@GetMapping(value = "/api/users/{id}/checking-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<BankAccount> getCheckingAccountById(@PathVariable("id") String userName, @PathVariable("aid") long id) {
		return service.getCheckingAccountById(id);
	}

	@PostMapping(value = "/api/users/{id}/checking-account")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount postCheckingAccount(@PathVariable("id") String userName,
			@RequestBody @Validated CheckingAccount account) {
		return service.addCheckingAccount(account, userName);
	}
	
	@DeleteMapping(value = "/api/users/{id}/checking-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public boolean deleteCheckingAccount(@PathVariable("id") String userName, @PathVariable("aid") long aid) {
		return service.removeCheckingAccountById(aid);
	}
	
	// CD Account APIs =============================================================

	@GetMapping(value = "/api/users/{id}/certificate-of-deposit-accounts")
	@ResponseStatus(HttpStatus.OK)
	public List<BankAccount> getCDAccounts(@PathVariable("id") String userName) {
		return service.getCDAccounts(userName);
	}
	
	@GetMapping(value = "/api/users/{id}/certificate-of-deposit-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<BankAccount> getCDAccountById(@PathVariable("id") String userName, @PathVariable("aid") long id) {
		return service.getCDAccountById(id);
	}

	@PostMapping(value = "/api/users/{id}/certificate-of-deposit-account")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount postCDAccount(@PathVariable("id") String userName,
			@RequestBody @Validated CDAccount account) {
		return service.addCDAccount(account, userName);
	}
	
	@DeleteMapping(value = "/api/users/{id}/certificate-of-deposit-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public boolean deleteCDAccount(@PathVariable("id") String userName, @PathVariable("aid") long aid) {
		return service.removeCDAccountById(aid);
	}
	
	// DBA Account APIs ============================================================

	@GetMapping(value = "/api/users/{id}/dba-accounts")
	@ResponseStatus(HttpStatus.OK)
	public List<BankAccount> getDBAAccounts(@PathVariable("id") String userName) {
		return service.getDBAAccounts(userName);
	}
	
	@GetMapping(value = "/api/users/{id}/dba-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<BankAccount> getDBAAccountById(@PathVariable("id") String userName, @PathVariable("aid") long id) {
		return service.getDBAAccountById(id);
	}

	@PostMapping(value = "/api/users/{id}/dba-account")
	@ResponseStatus(HttpStatus.CREATED)
	public DBAAccount postDBAAccount(@PathVariable("id") String userName,
			@RequestBody @Validated DBAAccount account) {
		return service.addDBAAccount(account, userName);
	}
	
	@DeleteMapping(value = "/api/users/{id}/dba-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public boolean deleteDBAAccount(@PathVariable("id") String userName, @PathVariable("aid") long aid) {
		return service.removeDBAAccountById(aid);
	}

	// Personal Checking Account APIs =============================================

	@GetMapping(value = "/api/users/{id}/personal-checking-accounts")
	@ResponseStatus(HttpStatus.OK)
	public List<BankAccount> getPersonalCheckingAccount(@PathVariable("id") String userName) {
		return service.getDBAAccounts(userName);
	}
	
	@GetMapping(value = "/api/users/{id}/personal-checking-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<BankAccount> getPersonalCheckingAccountById(@PathVariable("id") String userName, @PathVariable("aid") long id) {
		return service.getDBAAccountById(id);
	}

	@PostMapping(value = "/api/users/{id}/personal-checking-account")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonalCheckingAccount postPersonalCheckingAccount(@PathVariable("id") String userName,
			@RequestBody @Validated PersonalCheckingAccount account) {
		return service.addPersonalCheckingAccount(account, userName);
	}
	
	@DeleteMapping(value = "/api/users/{id}/personal-checking-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public boolean deletePersonalCheckingAccount(@PathVariable("id") String userName, @PathVariable("aid") long aid) {
		return service.removePersonalCheckingAccountById(aid);
	}

	// Regular IRA APIs ============================================================

	@GetMapping(value = "/api/users/{id}/regular-ira-account")
	@ResponseStatus(HttpStatus.OK)
	public IRAccount getRegularIRAccount(@PathVariable("id") String userName) {
		return service.getRegularIRA(userName);
	}
	
	@GetMapping(value = "/api/users/{id}/regular-ira-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<IRAccount> getRegularIRAccountById(@PathVariable("id") String userName, @PathVariable("aid") long id) {
		return service.getRegularIRAccountById(id);
	}

	@PostMapping(value = "/api/users/{id}/regular-ira-account")
	@ResponseStatus(HttpStatus.CREATED)
	public IRAccount postRegularIRAccount(@PathVariable("id") String userName,
			@RequestBody @Validated RegularIRA account) {
		return service.addRegularIRAccount(account, userName);
	}
	
	@DeleteMapping(value = "/api/users/{id}/regular-ira-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public boolean deleteRegularIRAccount(@PathVariable("id") String userName, @PathVariable("aid") long aid) {
		return service.removeRegularIRAccountById(aid);
	}

	// Rollover IRA APIs ===========================================================

	@GetMapping(value = "/api/users/{id}/rollover-ira-account")
	@ResponseStatus(HttpStatus.OK)
	public IRAccount getRolloverIRAccount(@PathVariable("id") String userName) {
		return service.getRolloverIRA(userName);
	}
	
	@GetMapping(value = "/api/users/{id}/rollover-ira-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<IRAccount> getRolloverIRAccountById(@PathVariable("id") String userName, @PathVariable("aid") long id) {
		return service.getRolloverIRAccountById(id);
	}

	@PostMapping(value = "/api/users/{id}/rollover-ira-account")
	@ResponseStatus(HttpStatus.CREATED)
	public IRAccount postRolloverIRAccount(@PathVariable("id") String userName,
			@RequestBody @Validated RolloverIRA account) {
		return service.addRolloverIRAccount(account, userName);
	}
	
	@DeleteMapping(value = "/api/users/{id}/rollover-ira-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public boolean deleteRolloverIRAccount(@PathVariable("id") String userName, @PathVariable("aid") long aid) {
		return service.removeRolloverIRAccountById(aid);
	}

	// Roth IRA APIs ===============================================================

	@GetMapping(value = "/api/users/{id}/roth-ira-account")
	@ResponseStatus(HttpStatus.OK)
	public IRAccount getRothIRAccount(@PathVariable("id") String userName) {
		return service.getRothIRA(userName);
	}
	
	@GetMapping(value = "/api/users/{id}/roth-ira-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<IRAccount> getRothIRAccountById(@PathVariable("id") String userName, @PathVariable("aid") long id) {
		return service.getRothIRAccountById(id);
	}

	@PostMapping(value = "/api/users/{id}/roth-ira-account")
	@ResponseStatus(HttpStatus.CREATED)
	public IRAccount postRothIRAccount(@PathVariable("id") String userName,
			@RequestBody @Validated RothIRA account) {
		return service.addRothIRAccount(account, userName);
	}
	
	@DeleteMapping(value = "/api/users/{id}/roth-ira-account/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public boolean deleteRothIRAccount(@PathVariable("id") String userName, @PathVariable("aid") long aid) {
		return service.removeRothIRAccountById(aid);
	}

	// Transaction APIs ============================================================

	// Return a list of transactions for a particular user:
	@GetMapping(value = "/api/users/{id}/transactions")
	@ResponseStatus(HttpStatus.OK)
	public List<Transaction> getTransactions(@PathVariable("id") String userName) {
		return service.getTransactionsByUser(userName);
	}

	// Return a list of all transactions in the database:
	@GetMapping(value = "/api/transactions")
	@ResponseStatus(HttpStatus.OK)
	public List<Transaction> getAllTransactions() {
		return service.getTransactions();
	}

	// Add transaction for a particular user:
	@PostMapping(value = "/api/users/{id}/transactions")
	@ResponseStatus(HttpStatus.CREATED)
	public Transaction postTransaction(@PathVariable("id") String userName,
			@RequestBody @Validated Transaction transaction) {
		return service.addTransaction(transaction, userName);
	}

	// Delete transaction:
	@DeleteMapping("/api/transactions/{tid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<User> removeTransactionById(@PathVariable("id") Long userName, @PathVariable("tid") Long tid) {
		service.removeTransactionById(tid);
		return null;
	}

}
