package com.bank.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransferDto {
    private int fromAccountId;
    private int toAccountId;
    private BigDecimal amount;

    public int getFromAccount() {
    }

    public int getToAccount() {
        return 0;
    }
}
