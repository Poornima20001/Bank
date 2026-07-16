package com.Bankingapplication.Bank.account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bankingapplication.Bank.transactionhistory.TransactionResponse;

public interface AccountRepository extends JpaRepository<Account,String> {

	List<TransactionResponse> findByAccountId(String accountId);

}
