package com.app.gptech.mapper;

import com.app.gptech.dto.AccountDto;
import com.app.gptech.entity.Account;

public class AccountMapper {

	public static Account accountDtoToAccount(AccountDto accountDto) {
		
		return new Account(
                accountDto.getId(),
                accountDto.getAccountNo(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
		
		
	}

	public static AccountDto accountToAccountDto(Account account) {
		
		return new AccountDto(
				account.getId(),
				account.getAccountNo(),
				account.getAccountHolderName(),
				account.getBalance()
        );
		
	}

}
