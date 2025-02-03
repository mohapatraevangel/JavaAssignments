package com.bankapp01.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AccountDto {
    private int id;
    private String name;
    private BigDecimal balance;

    public AccountDto(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }
}
