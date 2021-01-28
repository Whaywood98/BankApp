package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.bankcapstone.models.CheckingAccount;


public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {

}
