package com.example.bank.controller.dto;

public class AmountDto {

    private double amount;

    public AmountDto() {
    }

    public AmountDto(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
