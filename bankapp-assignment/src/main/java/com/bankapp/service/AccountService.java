package com.bankapp.service;
import com.bankapp.entities.Account;

import java.math.BigDecimal;

public interface AccountService {
    public void transfer(int from, int to, BigDecimal amount);
    public void deposit(int id, double amount);
    public Account findById(int id);
}
