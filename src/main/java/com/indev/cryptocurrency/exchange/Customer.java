package com.indev.cryptocurrency.exchange;

public class Customer {
    private Cryptocurrency cryptocurrency;
    int balance;

    public Customer withCryptocurrency(String bitcoin, int i) {
        this.cryptocurrency = new Cryptocurrency(bitcoin, i);
        return this;
    }

    public Customer withBalance(int i) {
        balance = i;
        return this;
    }

    public Cryptocurrency getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(Cryptocurrency cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String toString() {
        String s = balance + ":$";
        if (getCryptocurrency() != null) {
            s += "," + getCryptocurrency().getQte() + ":" + getCryptocurrency().getType();
        }
        return s;
    }
}
