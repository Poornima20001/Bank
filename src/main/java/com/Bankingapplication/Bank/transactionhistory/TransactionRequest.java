package com.Bankingapplication.Bank.transactionhistory;

import java.time.LocalDateTime;

import com.Bankingapplication.Bank.account.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {
	private String accountId;          // ID of the account
    private TransactionType Type;
    private Double amount;
    private String message;
		// TODO Auto-generated method stub
		
	
}
