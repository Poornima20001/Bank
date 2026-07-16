package com.Bankingapplication.Bank.account;

import java.time.LocalDateTime;
import java.util.List;

import com.Bankingapplication.Bank.transactionhistory.TransactionHistory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    //@Column(length = 50)
    private String accountid; // String for SBI prefix

    private String holderName;

    private Double balance;

    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL )//orphanRemoval = true)
    private List<TransactionHistory> transactions;
}