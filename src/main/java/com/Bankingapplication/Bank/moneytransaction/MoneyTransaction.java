package com.Bankingapplication.Bank.moneytransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bankingapplication.Bank.account.Account;
import com.Bankingapplication.Bank.account.AccountRepository;
import com.Bankingapplication.Bank.transactionhistory.TransactionHistoryRepository;
import com.Bankingapplication.Bank.transactionhistory.TransactionRequest;
import com.Bankingapplication.Bank.transactionhistory.TransactionService;
import com.Bankingapplication.Bank.transactionhistory.TransactionType;

import jakarta.transaction.Transactional;
@Service
public class MoneyTransaction{
	private TransactionService repo;
	@Autowired
	private AccountRepository moneyrepo;
	//deposit
	public Double deposit( String accountid,Double amount) {
		Account account=moneyrepo.findById(accountid).
				           orElseThrow(()->new RuntimeException("account not found"));
		account.setBalance(account.getBalance()+amount);
		moneyrepo.save(account);
		repo.saveHistory(TransactionRequest.builder()
                .accountId(accountid)
                .Type(TransactionType.DEPOSIT)
                .amount(amount)
                .message("Deposit successful")
                .build());
		return account.getBalance();
		
	}
	//withdraw
	public Double withdraw(String accountid,Double amount) {
		Account account=moneyrepo.findById(accountid).orElseThrow(()->
		new RuntimeException("Account not found"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient balance");
		}
		account.setBalance(account.getBalance()-amount);
		moneyrepo.save(account);
		 repo.saveHistory(TransactionRequest.builder()
	                .accountId(accountid)
	                .Type(TransactionType.WITHDRAW)
	                .amount(amount)
	                .message("Withdraw successful")
	                .build());
		return account.getBalance();
		
		
		
	}
	//transaction
	@Transactional
	public String Transation(String fromid,String toid,Double amount) {
		Account senter= moneyrepo.findById(fromid).orElseThrow(()->
		new RuntimeException("Senter not found"));
		Account recevier=moneyrepo.findById(toid).orElseThrow(()->
		new RuntimeException("Receiver not found"));
		if(senter.getBalance()<amount) {
			throw new RuntimeException("Insufficent amount");
		}
		
		senter.setBalance(senter.getBalance()-amount);
		
		recevier.setBalance(recevier.getBalance()+amount);
		moneyrepo.save(senter);
		moneyrepo.save(recevier);
		 repo.saveHistory(TransactionRequest.builder()
	                .accountId(fromid)
	                .Type(TransactionType.TRANSFER)
	                .amount(amount)
	                .message("Transferred to account: " + fromid)
	                .build());
		 
		 repo.saveHistory(TransactionRequest.builder()
	                .accountId(toid)
	                .Type(TransactionType.TRANSFER)
	                .amount(amount)
	                .message("Received from account: " + toid)
	                .build());

		return "transfer successfully";
		}
		
		
	}
	
	
