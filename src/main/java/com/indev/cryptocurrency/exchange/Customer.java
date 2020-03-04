package com.indev.cryptocurrency.exchange;

public class Customer {

    private Wallet wallet;
    private int balance =0;

    public Customer() {
        //wallet=new Wallet();
    }

    public Customer(Wallet wallet, int balance) {
        this.wallet = wallet;
        this.balance = balance;
    }

    @Override
    public String toString() {
        String output = balance+":$";
        if(wallet!=null)
            output+=","+wallet.getCount()+":"+wallet.getCrypto().toString();
        //return balance+":$,"+wallet.getCount()+":"+wallet.getCrypto().toString();
        return output;
    }

    public Customer withCryptocurrency(String bitcoin, int i) {
        wallet=new Wallet();
        wallet.setCrypto(CryptoFactory.getCryptocurrency(bitcoin));
        wallet.setCount(i);
        //return new Customer(new Wallet(CryptoFactory.getCryptocurrency(bitcoin),i),0);
        return this;
    }

    public Customer withBalance(int i) {
        balance = i;
        return this;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public int getBalance() {
        return balance;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
