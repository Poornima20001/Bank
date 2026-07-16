package com.Bankingapplication.Bank.transactionhistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	@Autowired
	private Transactioninterface transactioninter;
	@GetMapping
	public List<TransactionHistory>getAll(@PathVariable Long id){
		return transactioninter.findByAccountId(id);
	}
	
	@GetMapping("/deposit")
	public List<TransactionHistory>getDeposit(@PathVariable Long id){
		return transactioninter.findByAccountIdAndType(id, "DEPOSIT");
	}
	

	@GetMapping("/withdraw")
	public List<TransactionHistory>getwithdraw(@PathVariable Long id){
		return transactioninter.findByAccountIdAndType(id, "WITHDRAW");
	}
	
	@GetMapping("/transfer")
	public List<TransactionHistory>gettransfers(@PathVariable Long id){
		return transactioninter.findByAccountIdAndType(id, " TRANSFER");
	}

}
