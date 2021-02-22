package com.example.bank.service;

import com.example.bank.domain.BankAccount;
import com.example.bank.exception.BankAccountNotFoundException;
import com.example.bank.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount loadBankAccount(Long id){
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new BankAccountNotFoundException("Account ID not available !!"));
    }

    public BankAccount deposit(Long id, double amount){
        BankAccount bankAccount = loadBankAccount(id);
        bankAccount.deposit(amount);
        bankAccountRepository.save(bankAccount);
        return bankAccount;
    }

    public BankAccount withdraw(Long id, double amount){
        BankAccount bankAccount = loadBankAccount(id);
        bankAccount.withdraw(amount);
        bankAccountRepository.save(bankAccount);
        return bankAccount;
    }

    public BankAccount createBankAccount(double amount){
        BankAccount bankAccount = new BankAccount(amount);
        bankAccountRepository.save(bankAccount);
        return bankAccount;
    }
}
