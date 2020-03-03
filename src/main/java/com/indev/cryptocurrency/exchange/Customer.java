package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class Customer {

    private String cryptoCurrency;
    private int quantity;


    public Customer() {
    }

    public Customer withCryptocurrency(String cryptoCurrency, int i) {
        this.cryptoCurrency = cryptoCurrency;
        this.quantity = i;
        return this;
    }

    public Customer withBalance(int i) {
        return null;
    }

    @Override
    public String toString() {
        return "0:$,"+this.quantity+":"+this.cryptoCurrency;
    }
}
