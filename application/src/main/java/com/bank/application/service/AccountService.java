package com.bank.application.service;

import com.bank.application.entities.Account;
import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public void transfer(int from, int to, BigDecimal amount);
    public void deposite(int id, BigDecimal amount);
    public Account findById(int id);
    public List<Account> getAll();

    Account finById(int id);
}
