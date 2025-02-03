package com.bankapp01.bankapp.service;

import com.bankapp01.bankapp.dto.AccountDto;
import com.bankapp01.bankapp.dto.DepositeDto;
import com.bankapp01.bankapp.dto.TransferDto;
import com.bankapp01.bankapp.dto.WithdrawDto;
import com.bankapp01.bankapp.entities.Account;
import com.bankapp01.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp01.bankapp.repo.AccountRepo;
import com.bankapp01.bankapp.util.ConvertUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepo.findAll()
                .stream()
                .map(ConvertUtil::convertToAccountDto).toList();
    }


    @Override
    public AccountDto getAccount(int id) {
        return accountRepo
                .findById(id)
                .map(ConvertUtil::convertToAccountDto)
                .orElseThrow(() -> new BankAccountNotFoundException("account with id" + id + "not found"));
    }

    @Override
    public String transfer(TransferDto transferDto) {
        //get both accounts
        Account fromAcc=ConvertUtil.convertToAccount(getAccount(transferDto.getFromAccountId()));
        Account toAcc=ConvertUtil.convertToAccount(getAccount(transferDto.getToAccountId()));

        fromAcc.setBalance(fromAcc.getBalance().subtract(transferDto.getAmount()));
        toAcc.setBalance(toAcc.getBalance().add(transferDto.getAmount()));

        accountRepo.save(fromAcc);
        accountRepo.save(toAcc);

        return "fund is transferred successful";
    }

    @Override
    public String deposit(DepositeDto depositeDto) {
        Account acc=ConvertUtil.convertToAccount(getAccount(depositeDto.getAccountId()));
        acc.setBalance(acc.getBalance().add(depositeDto.getAmount()));
        accountRepo.save(acc);
        return "deposit done successful";
    }

    @Override
    public String withdraw(WithdrawDto withdrawDto) {
        Account acc = ConvertUtil.convertToAccount(getAccount(withdrawDto.getAccountId()));
        acc.setBalance(acc.getBalance().subtract(withdrawDto.getAmount()));
        accountRepo.save(acc);
        return "withdraw done successful";


    }
}
