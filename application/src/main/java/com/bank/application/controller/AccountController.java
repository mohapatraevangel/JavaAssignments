package com.bank.application.controller;

import com.bank.application.dto.DepositeDto;
import com.bank.application.dto.TransferDto;
import com.bank.application.entities.Account;
import com.bank.application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable int id) {
        return accountService.finById(id);
    }

    @PostMapping ("transfer")
    public String transfer(@RequestBody TransferDto transferDto) {
        accountService.transfer(transferDto.getFromAccount(), transferDto.getToAccount(), transferDto.getAmount());
        return "Transfer is successful";
    }

    @PostMapping ("deposit")
    public String deposit(@RequestBody DepositeDto depositDto) {
        accountService.deposite(depositDto.getAccountId(), depositDto.getAmount());
        return "Deposit is successful";
    }
}
