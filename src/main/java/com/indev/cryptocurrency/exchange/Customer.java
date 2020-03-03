package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class Customer {

    private String cryptoCurrency;
    private int quantity;
    private int balance;

    public Customer() {
    }

    public Customer withCryptocurrency(String cryptoCurrency, int i) {
        this.cryptoCurrency = cryptoCurrency;
        this.quantity = i;
        return this;
    }

    public Customer withBalance(int i) {
        this.balance=i;
        return this;
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        if(cryptoCurrency==null) return  balance+":$";
        return balance+":$,"+this.quantity+":"+this.cryptoCurrency;
    }
}
