package com.example.bank.controller.dto;

import com.example.bank.domain.BankAccount;

public class BankAccountDto {

    private final Long id;

    private final double balance;

    public BankAccountDto(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public static BankAccountDto toDto(BankAccount bankAccount) {
        return new BankAccountDto(bankAccount.getId(), bankAccount.getBalance());
    }

    public Long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
}
