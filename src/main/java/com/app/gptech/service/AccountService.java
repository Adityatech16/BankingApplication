package com.app.gptech.service;

import java.util.List;

import com.app.gptech.dto.AccountDto;

public interface AccountService {

	public AccountDto addAccount(AccountDto accountdto);

	
	
	//  public AccountDto AddAllAccouts(List<AccountDto> accountDtos);
	  
	  public AccountDto getAccountByAccountNo(int accountNo);
	  
     public List<AccountDto> getAllAccounts();
	  
	 public AccountDto depositeAmount(int accointNo,Double amount );
	  
	//  public AccountDto withdralAmount(int accointId,AccountDto accountDto );
//	  public String deleteAccount(int accountNo);



	 //  AccountDto AccountByAccountNo(int accountNo);



	//public AccountDto getAccountById(int accountNo);
	 
}
