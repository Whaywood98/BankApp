package com.meritamerica.bankcapstone.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	
}
