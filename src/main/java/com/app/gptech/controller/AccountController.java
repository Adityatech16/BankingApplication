package com.app.gptech.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.gptech.dto.AccountDto;
import com.app.gptech.service.AccountService;

@RestController
@RequestMapping("/bankapp")
public class AccountController {
 private Logger logger=LoggerFactory.getLogger(AccountController.class);
	@Autowired
	private AccountService accountService;

	@PostMapping("/addaccount")
	public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto accountdto) {
		logger.info("Input data"+accountdto);
		AccountDto addAccount = accountService.addAccount(accountdto);
		return ResponseEntity.status(HttpStatus.CREATED).body(addAccount);

	}

	 @GetMapping("/accounts/{accountNo}")
	    public ResponseEntity<AccountDto> getAccountByaccountNo(@PathVariable int accountNo) {
	        AccountDto account = accountService.getAccountByAccountNo(accountNo);
	        return ResponseEntity.ok(account);
	    }
	
	 @GetMapping("/accounts")
	public ResponseEntity<List<AccountDto>> getAllAccounts()
	{
		 List<AccountDto> allAccounts = accountService.getAllAccounts();
		  
		 
		 return ResponseEntity.ok(allAccounts);
    }
		
	 
	 
	 
	  @PostMapping("/accounts/{accountNo}/deposit")
	    public ResponseEntity<AccountDto> depositMoney(@PathVariable int accountNo, @RequestParam Double amount) {
	        AccountDto updatedAccount = accountService.depositeAmount(accountNo, amount);
	        return ResponseEntity.ok(updatedAccount);
	    }

	}
	
	

