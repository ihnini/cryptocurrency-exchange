package com.indev.cryptocurrency.exchange;

public class Customer {
    private Cryptocurrency cryptocurrency;
    int balance;

    public Customer withCryptocurrency(String bitcoin, int i) {
        this.cryptocurrency = new Cryptocurrency(bitcoin,i);
        return this;
    }

    public Customer withBalance(int i) {
        balance = i;
        return this;
    }

    @Override
    public String toString() {
        return balance+":$,"+cryptocurrency.getPrice()+":"+cryptocurrency.getType();
    }
}
