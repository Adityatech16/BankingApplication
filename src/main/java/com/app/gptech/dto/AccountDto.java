package com.app.gptech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AccountDto {
	private int id;
	private int accoutNo;
	private String accountHoldeName;
	private Double balance;

}
