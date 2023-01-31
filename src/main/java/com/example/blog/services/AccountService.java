package com.example.blog.services;

import com.example.blog.models.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);
    List<Account> findByEmail(String email);
}
