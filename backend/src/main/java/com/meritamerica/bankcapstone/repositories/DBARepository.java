package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.bankcapstone.models.DBAAccount;

public interface DBARepository extends JpaRepository<DBAAccount, Long> {

}
