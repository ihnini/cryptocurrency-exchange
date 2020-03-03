package com.indev.cryptocurrency.exchange;

public class Customer {

    private Wallet wallet;
    private int balance =0;

    public Customer() {
        wallet=new Wallet();
    }

    public Customer(Wallet wallet, int balance) {
        this.wallet = wallet;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return balance+":$,"+wallet.getCount()+":"+wallet.getCrypto().toString();
    }

    public Customer withCryptocurrency(String bitcoin, int i) {
        wallet.setCrypto(CryptoFactory.getCryptocurrency(bitcoin));
        wallet.setCount(i);
        //return new Customer(new Wallet(CryptoFactory.getCryptocurrency(bitcoin),i),0);
        return this;
    }

    public Customer withBalance(int i) {
        return null;
    }
}
