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
public class TransactionResponse {
	private Long id;
    private String accountId;
    private TransactionType type;
    private Double amount;
    private LocalDateTime date;
    private String message;

}
