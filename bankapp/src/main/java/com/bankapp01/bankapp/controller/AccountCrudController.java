package com.bankapp01.bankapp.controller;

import com.bankapp01.bankapp.dto.AccountDto;
import com.bankapp01.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")

public class AccountCrudController {

    private AccountService accountService;

    @Autowired
    public AccountCrudController(AccountService accountService) {
        this.accountService = accountService;
    }
    //get All Accounts

    @GetMapping("account")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    //get by id

}

