package com.Bankingapplication.Bank.account;

import java.time.LocalDateTime;


import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;


public class AccountMapper {
public static Account toEntity(AccountRequest request) {
	String generatedId = "SBI" + System.currentTimeMillis();


	Account account=Account.builder().holderName(request.getHolderName())
    .balance(request.getBalance() != null ? request.getBalance() : 0.0)
    .createdDate(LocalDateTime.now())
    .accountid(generatedId) // 
    .build();
	return account;
}
//private Long accountId;
//private String holderName;
//private Double balance;
//private LocalDateTime createdDate;


public static AccountResponse dto(Account account) {
	AccountResponse dto= AccountResponse.builder().accountid(account.getAccountid()).
			holderName(account.getHolderName()).balance(account.getBalance()).
			createdDate(account.getCreatedDate()).build();
	return dto;
	
}


}
