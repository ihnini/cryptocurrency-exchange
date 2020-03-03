package com.indev.cryptocurrency.exchange;

public class Customer {

    private String cryptocurrency;
    private int wallet;
    private int balance;

    public Customer() {
    }

    public String getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(String cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return getBalance() + ":$," + getWallet() + ":" + getCryptocurrency();
    }

    public Customer withCryptocurrency(String bitcoin, int i) {
        setCryptocurrency(bitcoin);
        setWallet(i);
        return this;
    }

    public Customer withBalance(int i) {
        return null;
    }


}
