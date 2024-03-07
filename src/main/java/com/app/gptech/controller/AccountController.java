package com.app.gptech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
