package com.bankapp.service;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDaoImpl;

    @Autowired
    private AccountDao accountDao;
}
