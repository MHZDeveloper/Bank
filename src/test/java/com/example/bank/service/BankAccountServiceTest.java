package com.example.bank.service;

import com.example.bank.exception.BankAccountNotFoundException;
import com.example.bank.repositories.BankAccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class BankAccountServiceTest {

    private final BankAccountRepository bankAccountRepository = Mockito.mock(BankAccountRepository.class);
    private final BankAccountService bankAccountService = new BankAccountService(bankAccountRepository);

    @Test
    void should_throw_exception_when_getting_unknown_id() {
        //given
        Mockito.doReturn(Optional.empty()).when(bankAccountRepository).findById(2L);

        //when & then
        Assertions.assertThatThrownBy(() -> {
            bankAccountService.loadBankAccount(2L);
        }).isInstanceOf(BankAccountNotFoundException.class)
                .hasMessage("Account ID not available !!");
    }
}