package com.indev.cryptocurrency.exchange;


public class Customer {

    String bitcoin ;
    int quantity = 0;
    boolean hasCrypto = false;
    int balance = 0;

    public Customer withCryptocurrency(String bitcoin, int i) {
        hasCrypto = true;
        this.bitcoin = bitcoin;
        this.quantity += i;
        return this;
    }
    public Customer withBalance(int i){
        this.balance += i;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(balance+":$");
        if(hasCrypto) res.append(","+quantity+":"+bitcoin);
        return res.toString();
    }
}
