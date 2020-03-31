package com.indev.cryptocurrency.exchange;

public class Customer {

    private String cryptoCurrency;
    private int cryptoCurrencyAmount;
    private int balance;

    public Customer() {
        this.cryptoCurrencyAmount = 0;
        this.balance = 0;
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public int getCryptoCurrencyAmount() {
        return cryptoCurrencyAmount;
    }

    public void setCryptoCurrencyAmount(int cryptoCurencyAmount) {
        this.cryptoCurrencyAmount = cryptoCurencyAmount;
    }

    public Customer withCryptocurrency(String cryptoCurrency, int cryptoCurrencyAmount) {
        this.cryptoCurrency = cryptoCurrency;
        this.cryptoCurrencyAmount = cryptoCurrencyAmount;
        return this;
    }

    public Customer withBalance(int balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public String toString() {
        return cryptoCurrency==null ?balance + ":$" : balance + ":$," + cryptoCurrencyAmount + ":" + cryptoCurrency;
    }
}
