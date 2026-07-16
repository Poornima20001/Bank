package com.Bankingapplication.Bank.account;

import java.time.LocalDateTime;
import java.util.List;

import com.Bankingapplication.Bank.account.Account.AccountBuilder;
import com.Bankingapplication.Bank.transactionhistory.TransactionHistory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponse {
	private String accountid;
	private String holderName;
	private Double balance;
	private LocalDateTime createdDate;
	

}
