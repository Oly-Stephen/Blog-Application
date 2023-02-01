package com.example.blog.services.impl;

import com.example.blog.models.Account;
import com.example.blog.repositories.AccountRepository;
import com.example.blog.services.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findByEmail(String email) {
        return accountRepository.findOneByEmail(email);

    }
}
