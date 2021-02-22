package com.example.bank.controller;

import com.example.bank.domain.BankAccount;
import com.example.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankAccountController {

    private BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/api/bankaccounts/{id}")
    public BankAccount loadBankAccount(@PathVariable Long id){
        return bankAccountService.loadBankAccount(id);
    }

    @PostMapping("/api/bankaccounts/{amount}")
    public BankAccount createBankAccount(@PathVariable double amount){
        return bankAccountService.createBankAccount(amount);
    }

    @PutMapping("/api/bankaccounts/{id}/deposit/{amount}")
    public BankAccount depositBankAccount(@PathVariable Long id, @PathVariable double amount){
        return bankAccountService.deposit(id,amount);
    }

    @PutMapping("/api/bankaccounts/{id}/withdraw/{amount}")
    public BankAccount withdrawBankAccount(@PathVariable Long id, @PathVariable double amount){
        return bankAccountService.withdraw(id,amount);
    }
}
