package com.Bankingapplication.Bank.transactionhistory;

import java.time.LocalDateTime;

import com.Bankingapplication.Bank.account.Account;

public class TransactionMapper {

    public static TransactionHistory toEntity(TransactionRequest request, Account account) {
        return TransactionHistory.builder()
                .account(account)
                .type(request.getType())
                .amount(request.getAmount())
                .date(LocalDateTime.now())
                .message(request.getMessage())
                .build();
    }

    public static TransactionResponse toResponse(TransactionHistory history) {
        return TransactionResponse.builder()
                .id(history.getId())
                .accountId(history.getAccountId())
                .type(history.getType())
                .amount(history.getAmount())
                .date(history.getDate())
                .message(history.getMessage())
                .build();
    }
}