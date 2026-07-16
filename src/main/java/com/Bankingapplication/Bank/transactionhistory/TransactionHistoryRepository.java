package com.Bankingapplication.Bank.transactionhistory;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bankingapplication.Bank.account.Account;
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Integer> {

	

	Optional<Account> findByAccount_IdAndType(String accountId, TransactionType type);

	Optional<Account> findByAccount_Id(String id);

	

	

}
