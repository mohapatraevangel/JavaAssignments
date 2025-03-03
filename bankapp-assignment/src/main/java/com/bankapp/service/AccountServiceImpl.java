package com.bankapp.service;

import com.bankapp.entities.Account;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {
    private  AccountRepo accountRepo;


    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public void transfer(int from, int to, BigDecimal amount) {
         Account fromAcc = findById(from);
         Account toAcc = findById(to);
         fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
         toAcc.setBalance(toAcc.getBalance().add(amount));
         accountRepo.save(fromAcc);
         accountRepo.save(toAcc);

    }

    @Override
    public void deposit(int id, double amount) {

    }

    @Override
    public Account findById(int id) {
        return null;
    }
}
