package com.bankapp01.bankapp;

import com.bankapp01.bankapp.entities.Account;
import com.bankapp01.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {

	@Autowired
	private AccountRepo accountRepo;

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepo.save(new Account("raj", new BigDecimal(1000)));
		accountRepo.save(new Account("ekta", new BigDecimal(1000)));
	}
}
