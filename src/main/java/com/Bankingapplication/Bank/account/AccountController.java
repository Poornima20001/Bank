 package com.Bankingapplication.Bank.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	@Autowired
	private Accountinterface accountinter;
	@PostMapping("/accountname1" )
	public AccountResponse createaccount(@RequestBody AccountRequest dto) {
		return accountinter.createaccount(dto);
	}
	@GetMapping("/account/{id}")
	public AccountResponse  getaccount(@PathVariable String id){
		return accountinter.getaccount(id);
	}
	
	@DeleteMapping("/account/{id}")
public String deleteaccount(@PathVariable String id) {
	return accountinter.deleteaccount(id);
}

}
