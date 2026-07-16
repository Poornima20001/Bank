package com.Bankingapplication.Bank.transactionhistory;

import java.util.List;

public interface Transactioninterface {
	List<TransactionHistory> findByAccountId(Long accountId);
    List<TransactionHistory> findByAccountIdAndType(Long accountId, String type);
}
	

