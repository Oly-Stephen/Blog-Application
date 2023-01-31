package com.example.blog.repositories;

import com.example.blog.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findOneByEmail(String email);
}
