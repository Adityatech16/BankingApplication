package com.app.gptech.service;

import java.util.List;
import java.util.stream.Collectors;

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



	@Override
	public AccountDto getAccountByAccountNo(int accountNo) {
		
		
		
		Account account = (Account) accountRepository.findByaccountNo(accountNo)
                .orElseThrow(() -> new RuntimeException("Account not found with accountNo: " + accountNo));
       
		return AccountMapper.accountToAccountDto(account);
		
		
		
	}



	@Override
	public List<AccountDto> getAllAccounts() {
	    List<Account> accounts = accountRepository.findAll();
	    return accounts.stream()
	            .map(AccountMapper::accountToAccountDto)
	            .collect(Collectors.toList());
	}



	@Override
	public AccountDto depositeAmount(int accointNo, Double amount) {
		
		Account account = (Account) accountRepository.findByaccountNo(accointNo)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accointNo));
        account.setBalance(account.getBalance() + amount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.accountToAccountDto(savedAccount);
		
		
	}



	
}
