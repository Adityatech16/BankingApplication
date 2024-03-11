package com.app.gptech.mapper;

import java.util.List;
import java.util.stream.Collectors;

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

	public static List<Account> accountToAccountDto(List<Account> accounts) {
		
		return accounts.stream()
				.collect(Collectors.toList());
				
                

}
}
