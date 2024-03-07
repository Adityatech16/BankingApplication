package com.app.gptech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gptech.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
