package com.meritamerica.bankcapstone.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	
	
	@Autowired
	private UserRepository users;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return users.findAll();
	}
	
	@PostMapping("/users")
	public User postUser(@RequestBody @Valid User user) {
		users.save(user);
		return user;
	}
}
