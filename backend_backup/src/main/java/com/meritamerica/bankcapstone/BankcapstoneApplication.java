package com.meritamerica.bankcapstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.meritamerica.bankcapstone.repositories.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class BankcapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankcapstoneApplication.class, args);
	}

}
