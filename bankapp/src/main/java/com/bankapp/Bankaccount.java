package com.Bankapp;

import Exceptions.NotSufficientFundException;
import Exceptions.OverFundException;


public class Bankaccount {
    private double balance;
    private static final double MIN_BALANCE = 10000;
    private static final double MAX_BALANCE = 1500000;

    public Bankaccount(double initialBalance) throws Exception {
        if (initialBalance < MIN_BALANCE) throw new Exception("Minimum balance should be ₹" + MIN_BALANCE);
        if (initialBalance > MAX_BALANCE) throw new Exception("Maximum balance exceeded ₹" + MAX_BALANCE);
        this.balance = initialBalance;
   }

    // Deposit method
    public void deposit(double amount) throws OverFundException {
        if (balance + amount > MAX_BALANCE) throw new OverFundException("Cannot exceed max balance ₹" + MAX_BALANCE);
        balance += amount;
        System.out.println("Deposited: ₹" + amount + " | Balance: ₹" + balance);
    }

    // Withdraw method
    public void withdraw(double amount) throws NotSufficientFundException {
        if (balance - amount < MIN_BALANCE) throw new NotSufficientFundException("Must maintain min balance ₹" + MIN_BALANCE);
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount + " | Balance: ₹" + balance);

    }
}

