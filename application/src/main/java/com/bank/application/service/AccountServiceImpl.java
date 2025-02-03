package com.bank.application.service;

import com.bank.application.entities.Account;
import com.bank.application.exception.AccountNotFoundException;
import com.bank.application.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
@Service
@Transactional
public abstract class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;
    @Autowired
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
    public void deposite(int id, BigDecimal amount) {
        Account account = findById(id);
        account.setBalance(account.getBalance().add((amount)));
        accountRepo.save(account);
    }}


