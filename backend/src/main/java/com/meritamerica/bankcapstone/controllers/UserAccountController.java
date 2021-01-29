package com.meritamerica.bankcapstone.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.bankcapstone.models.SavingsAccount;
import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.services.UserAccountService;

@RestController
public class UserAccountController {

	@Autowired
	UserAccountService service;
	
	// User APIs =======================================================
	
	// Get all users:
	
	@GetMapping(value = "/Users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	// Get user by id:
	
	@GetMapping("/Users/{id}/")
	@ResponseStatus(HttpStatus.OK)
	public Optional<User> fetchUserById(@PathVariable("id") Long id) {
		return service.getUserById(id);
	}
	
	// Post user:
	
	@PostMapping(value = "/Users", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public String addUser(User user) {
		service.addUser(user);
		return user.toString();
	}
	
	// Delete user:
	
	@DeleteMapping("/Users/{id}/")
	@ResponseStatus(HttpStatus.OK)
	public Optional<User> removeUserById(@PathVariable("id") Long id) {
		service.removeUserById(id);
		return null;
	}
	
	// Savings Account APIs =======================================================

	// Get all saving accounts:
	
		@GetMapping(value = "/Users/SavingsAccount")
		@ResponseStatus(HttpStatus.OK)
		public List<SavingsAccount> getSavings(){
			return service.getSavingsAccounts();
		}
		
		// Get savings account by id:
		
		@GetMapping("/Users/SavingsAccount/{id}/")
		@ResponseStatus(HttpStatus.OK)
		public Optional<SavingsAccount> fetchSavingsById(@PathVariable("id") Long id) {
			return service.getSavingsAccountById(id);
		}
		
		// Post savings account:
		
		@PostMapping(value = "/Users", consumes = "application/json", produces = "application/json")
		@ResponseStatus(HttpStatus.CREATED)
		public String addUser(User user) {
			service.addUser(user);
			return user.toString();
		}
		
		// Delete user:
		
		@DeleteMapping("/Users/{id}/")
		@ResponseStatus(HttpStatus.OK)
		public Optional<User> removeUserById(@PathVariable("id") Long id) {
			service.removeUserById(id);
			return null;
		}
}
