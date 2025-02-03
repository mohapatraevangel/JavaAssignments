package com.bankapp01.bankapp.service;

import com.bankapp01.bankapp.dto.AccountDto;
import com.bankapp01.bankapp.dto.DepositeDto;
import com.bankapp01.bankapp.dto.TransferDto;
import com.bankapp01.bankapp.dto.WithdrawDto;
import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public List<AccountDto> getAllAccounts();
    public AccountDto getAccount(int id);
    public String transfer(TransferDto transferDto);
    public String deposit(DepositeDto depositeDto);
    public String withdraw(WithdrawDto withdrawDto);
}
