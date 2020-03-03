package com.indev.cryptocurrency.exchange;

public class Customer {

    private String cryptocurrencyType;
    private int quantity;
    private int balance;

    public Customer withCryptocurrency(String bitcoin, int i) {
        this.cryptocurrencyType = bitcoin;
        this.quantity = i;
        return this;
    }

    public Customer withBalance(int i) {
        this.balance = i;
        return this;
    }

    @Override
    public String toString() {
        return balance + ":$," + quantity + ":" + cryptocurrencyType;
    }
}
