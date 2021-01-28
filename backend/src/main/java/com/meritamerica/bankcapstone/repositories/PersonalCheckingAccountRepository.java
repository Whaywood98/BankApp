package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.bankcapstone.models.PersonalCheckingAccount;

public interface PersonalCheckingAccountRepository extends JpaRepository<PersonalCheckingAccount, Long> {

}
