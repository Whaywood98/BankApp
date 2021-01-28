package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.bankcapstone.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
