package com.bank.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositeDto {

    public int getAccountId() {
    }

    public BigDecimal getAmount() {
        return null;
    }
}
