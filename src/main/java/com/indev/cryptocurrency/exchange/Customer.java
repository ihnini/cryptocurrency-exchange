package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int wallet ;
    private int balance = 0;
    private String cryptocurrency ;

    public Customer(){
        this.wallet = 0 ;
        this.balance = 0 ;
        this.cryptocurrency = "" ;
    }

    public Customer withCryptocurrency(String bitcoin, int i) {
        this.cryptocurrency = bitcoin ;
        this.wallet = i ;
        return this ;
    }

    public Customer withBalance(int i) {
        this.balance = i ;
        return this;
    }

    @Override
    public String toString() {
        String s = ""+getBalance()+":$";
        if(getWallet() != 0)
           s += ","+getWallet()+":" ;
        if(!getCryptocurrency().isEmpty())
            s += getCryptocurrency();

        return s ;
    }

    public int getWallet() {
        return wallet;
    }

    public int getBalance() {
        return balance;
    }

    public String getCryptocurrency() {
        return cryptocurrency;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCryptocurrency(String cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }
}
