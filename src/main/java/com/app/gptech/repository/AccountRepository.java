package com.app.gptech.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gptech.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

	Optional<Object>findByaccountNo(int accountNo);



}
