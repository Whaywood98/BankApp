package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.bankcapstone.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
