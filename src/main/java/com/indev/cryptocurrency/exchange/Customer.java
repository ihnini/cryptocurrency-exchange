package com.indev.cryptocurrency.exchange;


public class Customer {

    private Cryptocurrency crypto = new Cryptocurrency();
    private int balance;

    public Customer withCryptocurrency(String bitcoin, int i) {
        
               crypto = new Cryptocurrency(bitcoin, i);

    return Customer.this;
    }

    public Customer withBalance(int i) {
       balance = i;
        return Customer.this;
    }

     public void setNameCrypto(String Name)
        {
            this.crypto.setName(Name);
        }

    public Cryptocurrency getCrypto() {
        return crypto;
    }

    public void setCrypto(Cryptocurrency crypto) {
        this.crypto = crypto;
    }

    @Override
    public String toString() {
        String msg ="";

            msg+=  ""+balance+":"+"$";
        if(crypto.getBalance()>0 )
            msg+=","+crypto.getBalance()+":"+ crypto.getName();
        return msg;
    }
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
