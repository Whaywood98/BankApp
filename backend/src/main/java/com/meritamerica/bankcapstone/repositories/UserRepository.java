package com.meritamerica.bankcapstone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meritamerica.bankcapstone.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUserName(String userName);
	
	@Query("SELECT u FROM User u WHERE u.userName = :userName")
	User findUserById(@Param("userName") String userName);
	
}
