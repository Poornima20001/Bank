package com.Bankingapplication.Bank.moneytransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class MoneyController {

    @Autowired
    private MoneyTransaction moneytrans;

    @PostMapping("/{accountid}/deposit")
    public Double deposit(@PathVariable String accountid,
                          @RequestParam Double amount) {
        return moneytrans.deposit(accountid, amount);
    }

    @PostMapping("/{accountid}/withdraw")
    public Double withdraw(@PathVariable String accountid,
                           @RequestParam Double amount) {
        return moneytrans.withdraw(accountid, amount);
    }

    @PostMapping("/transfer")
    public String transaction(@RequestParam String fromid,
                              @RequestParam String toid,
                              @RequestParam Double amount) {
        return moneytrans.Transation(fromid, toid, amount);
    }
}