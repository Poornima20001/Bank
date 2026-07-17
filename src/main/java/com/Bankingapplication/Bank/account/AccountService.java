package com.Bankingapplication.Bank.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bankingapplication.Bank.transactionhistory.TransactionHistoryRepository;


@Service
public class AccountService  implements Accountinterface{
	 @Autowired
	    private AccountRepository accountRepo;

	    @Autowired
	    private TransactionHistoryRepository txRepo;
	    // Create Account
	    
		public AccountResponse createaccount(AccountRequest request) {
			
			Account acc = AccountMapper.toEntity(request);
	        accountRepo.save(acc);
			System.out.println("hii, i'm ramalakshmi");
	        return AccountMapper.dto(acc);
		}
		public AccountResponse getaccount(String id ) {
			
			Optional<Account>opt= accountRepo.findById(id);
			if(opt.isPresent()) {
				return AccountMapper.dto(opt.get());
			}
			else {
				throw new RuntimeException("Account not Fount with id:"+id);
			}
		}

//		public AccountResponse updateAccount(String id AccountRequest request) {
//			Optional<Account>=accountRepo.findById(id).orElseThrow(()->throw new 
//			account.getHolderName(request.getHolderName()).getBalance(request.getBalance());
//			accountRepo.save(account);
//			return AccountMapper.dto(account);
//		}
		public String deleteaccount(String id) {
			if(accountRepo.existsById(id)) {
				accountRepo.deleteById(id);
				 return "Account delete sucussfully";
			}
			else {
				throw new RuntimeException("Account not fount with id:"+id);
			}
			 
			
			
		}
//		
	
	
}

