package com.meritamerica.bankcapstone.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.bankcapstone.models.SavingsAccount;
import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.services.UserAccountService;

@CrossOrigin(origins = "http://localhost:3000")
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
	
	@GetMapping("/Users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User fetchUserById(@PathVariable("id") String userName) {
		return service.getUserById(userName);
	}
	
	// Post user:
	
	@PostMapping(value = "/Users")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) { //validation goes here, too.
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
	
	// Savings Account APIs =======================================================

	// Get saving account:
	
//	@GetMapping(value = "/Users/{id}/SavingsAccount")
//	@ResponseStatus(HttpStatus.OK)
//	public SavingsAccount getSavings(){
//		return service.getgetSavingsAccounts();
//	}
//		
	
		
		

}
