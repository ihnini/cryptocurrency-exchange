package com.indev.cryptocurrency.exchange;

public class Customer {
    private String currency;
    private int dollard;
    private int quentity;

    public Customer(String currency, int quentity) {
        this.currency = currency;
        this.quentity = quentity;
    }
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

    public void setDollard(int dollard) {
        this.dollard = dollard;
    }

    public int getDollard() {
        return dollard;
    }

    @Override
    public String toString() {
        return this.getDollard()+":$,"+ this.getQuentity()+":"+this.getCurrency();
    }

    public Customer withCryptocurrency(String bitcoin, int i) {
        return new Customer(bitcoin,i);
    }

    public Customer withBalance(int i) {
        this.setDollard(i);
        return this;
    }
}
