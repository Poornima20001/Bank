package com.Bankingapplication.Bank.account;

import java.util.Optional;

public interface Accountinterface  {
	public AccountResponse createaccount(AccountRequest request);
	public AccountResponse getaccount(String id );
	//public AccountResponse updateAccount( AccountRequest request);
	 

	public String deleteaccount(String id);
}
