package com.indev.cryptocurrency.exchange;

public class Customer {
    private String currency;
    private int quentity;
    private int balance;



    public Customer() {
    }

    public String getCurrency() {
        return currency;
    }

    public int getQuentity() {
        return quentity;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        if(this.getCurrency() == null) {
            return this.getBalance()+":$";

        }
        return this.balance+":$,"+ this.getQuentity()+":"+this.getCurrency();
    }

    public Customer withCryptocurrency(String bitcoin, int i) {
        this.quentity = i;
        this.currency = bitcoin;
        return this;
    }

    public Customer withBalance(int i) {
        this.balance = i ;
        return this;
    }
}
