package com.indev.cryptocurrency.exchange;

public class Customer {
    private CryptoCurrency cryptoCurrency;
    private int balance;

    public Customer() {
        this.balance=0;
    }

    public CryptoCurrency getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Customer withCryptocurrency(String bitcoin, int i) {
        this.setCryptoCurrency(new CryptoCurrency(bitcoin,i));
        return this;
    }

    public Customer withBalance(int i) {
        this.setBalance(i);
        return this;
    }

    @Override
    public String toString() {
        return this.balance+":$"+this.displayCurrencyInfo();
    }

    private String displayCurrencyInfo() {
        if(this.cryptoCurrency==null)
            return "";
        else
            return ","+this.cryptoCurrency.toString();
    }
}
