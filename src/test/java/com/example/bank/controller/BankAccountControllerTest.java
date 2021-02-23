package com.example.bank.controller;

import com.example.bank.domain.BankAccount;
import com.example.bank.repositories.BankAccountRepository;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BankAccountControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void should_return_bank_account() {
        when()
                .post("/api/bankaccounts/500")
                .then()
                .statusCode(200);

        Assertions.assertThat(bankAccountRepository.findAll()).hasSize(1);
    }
}