package com.Bankapp;

import Exceptions.NotSufficientFundException;
import Exceptions.OverFundException;
import com.Bankapp.Bankaccount;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            // Creating a bank account with an initial balance of 10,000
            Bankaccount account = new Bankaccount(10000);

            // Withdrawing 5000 (Exception will be thrown as it goes below min balance)
            account.withdraw(5000);

            // Trying to deposit an amount exceeding the max limit (Exception will be thrown)
            account.deposit(1600000);
        } catch (NotSufficientFundException | OverFundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}