package com.bankapp.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Enabled
@Data
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private BigDecimal balance;

    public Account(BigDecimal balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}

