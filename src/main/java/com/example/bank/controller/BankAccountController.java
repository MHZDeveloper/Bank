package com.example.bank.controller;

import com.example.bank.domain.BankAccount;
import com.example.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank-account")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/{id}")
    public BankAccount loadBankAccount(@PathVariable Long id){
        return bankAccountService.loadBankAccount(id);
    }

    @PostMapping("/{amount}")
    public BankAccount createBankAccount(@PathVariable double amount){
        return bankAccountService.createBankAccount(amount);
    }

    @PutMapping("/{id}/deposit/{amount}")
    public BankAccount depositBankAccount(@PathVariable Long id, @PathVariable double amount){
        return bankAccountService.deposit(id,amount);
    }

    @PutMapping("/{id}/withdraw/{amount}")
    public BankAccount withdrawBankAccount(@PathVariable Long id, @PathVariable double amount){
        return bankAccountService.withdraw(id,amount);
    }
}
