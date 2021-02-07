package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.bankcapstone.models.IRAccount;

public interface IRARepository extends JpaRepository<IRAccount, Long> {

}