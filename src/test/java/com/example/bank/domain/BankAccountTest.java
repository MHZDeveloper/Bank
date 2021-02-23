package com.example.bank.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void should_correctly_deposit() {
        //given
        BankAccount bankAccount = new BankAccount(100);

        //when
        bankAccount.deposit(50);

        //then
        Assertions.assertThat(bankAccount.getBalance()).isEqualTo(150);
    }

    @Test
    void should_correctly_withdraw() {
        //given
        BankAccount bankAccount = new BankAccount(100);

        //when
        bankAccount.withdraw(50);

        //then
        Assertions.assertThat(bankAccount.getBalance()).isEqualTo(50);
    }
}