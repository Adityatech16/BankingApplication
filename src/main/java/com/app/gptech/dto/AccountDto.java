package com.app.gptech.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
	private int id;
	private int accountNo;
	private String accountHolderName;
	private Double balance;

}
