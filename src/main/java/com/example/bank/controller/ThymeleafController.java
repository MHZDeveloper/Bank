package com.example.bank.controller;

import com.example.bank.controller.dto.AmountDto;
import com.example.bank.controller.dto.BankAccountDto;
import com.example.bank.domain.BankAccount;
import com.example.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ThymeleafController {

    private final BankAccountService bankAccountService;

    @Autowired
    public ThymeleafController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/")
    public String displayIndex(Model model) {
        List<BankAccountDto> bankAccounts = bankAccountService
                .loadBankAccounts()
                .stream()
                .map(BankAccountDto::toDto)
                .collect(Collectors.toList());
        model.addAttribute("bankAccounts", bankAccounts);
        return "index";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("amount", new AmountDto());
        return "add";
    }

    @PostMapping("/add")
    public String createBankAccount(AmountDto amount) {
        bankAccountService.createBankAccount(amount.getAmount());
        return "redirect:/";
    }

    @GetMapping("/deposit/{id}")
    public String displayDepositForm(Model model, @PathVariable("id") Long id) {
        BankAccountDto bankAccount = BankAccountDto
                .toDto(bankAccountService.loadBankAccount(id));
        model.addAttribute("bankAccount", bankAccount);
        model.addAttribute("amount", new AmountDto());
        return "deposit";
    }

    @PostMapping("/deposit/{id}")
    public String depositBankAccount(@PathVariable("id") Long id, AmountDto amountDto) {
        bankAccountService.deposit(id,amountDto.getAmount());
        return "redirect:/";
    }

    @GetMapping("/withdraw/{id}")
    public String displayWithdrawForm(Model model, @PathVariable("id") Long id) {
        BankAccountDto bankAccount = BankAccountDto
                .toDto(bankAccountService.loadBankAccount(id));
        model.addAttribute("bankAccount", bankAccount);
        model.addAttribute("amount", new AmountDto());
        return "withdraw";
    }

    @PostMapping("/withdraw/{id}")
    public String withdrawBankAccount(@PathVariable("id") Long id, AmountDto amountDto) {
        bankAccountService.withdraw(id,amountDto.getAmount());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBankAccount(@PathVariable("id") Long id) {
        bankAccountService.deleteBankAccount(id);
        return "redirect:/";
    }
}
