package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meritamerica.bankcapstone.models.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	@Query("SELECT u FROM BankAccount u WHERE u.id = :account")
	BankAccount findBankAccountById(@Param("account") Long id);
}