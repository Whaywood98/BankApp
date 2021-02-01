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

import com.meritamerica.bankcapstone.models.Role;
import com.meritamerica.bankcapstone.models.SavingsAccount;
import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.services.UserAccountService;

@RestController
public class UserAccountController {

	@Autowired
	UserAccountService service;
	
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
	
	@GetMapping(value = "/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	// Get user by id:
	
	@GetMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<User> fetchUserById(@PathVariable("id") Long id) {
		return service.getUserById(id);
	}
	
	// Post user:
	
	// Posts a user. User access, only once.
	@PostMapping(value = "/users")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) { //validation goes here, too.
		service.addUser(user);
		return user;
	}
	
	// Delete user:
	
	// Deletes user by id. Will need admin access.
	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<User> removeUserById(@PathVariable("id") Long id) {
		service.removeUserById(id);
		return null;
	}
	
	// Savings Account APIs =======================================================

	// Get all saving accounts:
	
		@GetMapping(value = "/users/savings-accounts")
		@ResponseStatus(HttpStatus.OK)
		public List<SavingsAccount> getSavings(){
			return service.getSavingsAccounts();
		}
		
		// Get savings account by id:
		
		@GetMapping("/users/{id}/savings-account")
		@ResponseStatus(HttpStatus.OK)
		public Optional<SavingsAccount> fetchSavingsById(@PathVariable("id") Long id) {
			return service.getSavingsAccountById(id);
		}
		
		// Post savings account:
		
		@PostMapping(value = "/users/{id}/savings-account")
		@ResponseStatus(HttpStatus.CREATED)
		public SavingsAccount addSavings(@RequestBody @PathVariable("id") Long id, SavingsAccount account) { //validation goes here, too.
			service.addSavingsAccount(account, id);
			return account;
		}
		
		// Delete savings account:
		
		@DeleteMapping("/users/{id}/savings-account")
		@ResponseStatus(HttpStatus.OK)
		public Optional<SavingsAccount> removeSavings(@PathVariable("id") Long id) {
			service.removeSavingsAccountById(id);
			return null;
		}

		// Role APIs =======================================================
		
		// Get all roles:
		
		@GetMapping(value = "/roles")
		@ResponseStatus(HttpStatus.OK)
		public List<Role> getRoles(){
			return service.getRoles();
		}
		
		// Get role by id:
		
		@GetMapping("/roles/{id}")
		@ResponseStatus(HttpStatus.OK)
		public Optional<Role> fetchRoleById(@PathVariable("id") Long id) {
			return service.getRoleById(id);
		}
		
		// Post role:
		
		// Posts a role. User access, only once.
		@PostMapping(value = "/roles")
		@ResponseStatus(HttpStatus.CREATED)
		public Role addRole(@RequestBody Role role) { //validation goes here, too.
			service.addRole(role);
			return role;
		}
		
		// Delete role:
		
		// Deletes role by id. Will need admin access.
		@DeleteMapping("/roles/{id}")
		@ResponseStatus(HttpStatus.OK)
		public Optional<Role> removeRoleById(@PathVariable("id") Long id) {
			service.removeRoleById(id);
			return null;
		}
}
