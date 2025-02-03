package com.bankapp01.bankapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankapp01.bankapp.entities.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

        }


