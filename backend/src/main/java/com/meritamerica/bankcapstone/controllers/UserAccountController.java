package com.meritamerica.bankcapstone.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.services.UserAccountService;

@RestController
public class UserAccountController {

	@Autowired
	UserAccountService service;
	
	// Get user:
	
	@GetMapping(value = "/Users")
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	// Post user:
	
	@PostMapping(value = "/Users")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(User user) {
		service.addUser(user);
		return user;
	}
}
