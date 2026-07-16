package com.Bankingapplication.Bank.account;

import java.time.LocalDateTime;
import java.util.List;

import com.Bankingapplication.Bank.transactionhistory.TransactionHistory;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequest {
	@NotBlank(message = "Holder name must not be blank")
	private String holderName;
	@NotBlank(message = "Holder name must not be blank")
	private Double balance;
	

	
	
}
