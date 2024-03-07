package com.app.gptech.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.gptech.controller.AccountController;
import com.app.gptech.dto.AccountDto;
import com.app.gptech.entity.Account;
import com.app.gptech.mapper.AccountMapper;
import com.app.gptech.repository.AccountRepository;

@Service
public class AccountSetrviceImpl implements AccountService {
	private Logger logger=LoggerFactory.getLogger(AccountController.class);
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDto addAccount(AccountDto accountdto) {

		logger.info("result Data in service"+accountdto);
		Account accountDtoToAccount = AccountMapper.accountDtoToAccount(accountdto);

		Account accountreturndata = accountRepository.save(accountDtoToAccount);
		AccountDto accountToAccountDto = AccountMapper.accountToAccountDto(accountreturndata);

		return accountToAccountDto;
	}

}
