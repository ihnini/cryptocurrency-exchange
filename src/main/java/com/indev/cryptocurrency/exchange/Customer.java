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

    @Override
    public String toString() {
        return ""+balance+":$,"+this.quantity+":"+this.cryptoCurrency;
    }
}
