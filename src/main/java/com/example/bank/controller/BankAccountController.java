package com.example.bank.controller;

import com.example.bank.controller.dto.AmountDto;
import com.example.bank.controller.dto.BankAccountDto;
import com.example.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bank-account")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/")
    public List<BankAccountDto> loadBankAccounts() {
        return bankAccountService
                .loadBankAccounts()
                .stream()
                .map(BankAccountDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BankAccountDto loadBankAccount(@PathVariable Long id) {
        return BankAccountDto.toDto(bankAccountService.loadBankAccount(id));
    }

    @PostMapping("/")
    public BankAccountDto createBankAccount(@RequestBody AmountDto amount) {
        return BankAccountDto.toDto(bankAccountService.createBankAccount(amount.getAmount()));
    }

    @PutMapping("/{id}/deposit")
    public BankAccountDto depositBankAccount(@PathVariable Long id, @RequestBody AmountDto amount) {
        return BankAccountDto.toDto(bankAccountService.deposit(id, amount.getAmount()));
    }

    @PutMapping("/{id}/withdraw")
    public BankAccountDto withdrawBankAccount(@PathVariable Long id, @RequestBody AmountDto amount) {
        return BankAccountDto.toDto(bankAccountService.withdraw(id, amount.getAmount()));
    }
}
