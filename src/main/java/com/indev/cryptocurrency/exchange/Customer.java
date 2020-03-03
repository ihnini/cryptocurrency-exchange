package com.indev.cryptocurrency.exchange;


public class Customer {

    private String bitcoin;
    private int dollar = 0 ;
    private int i ;

    public Customer withCryptocurrency(String bitcoin,  int i) {

        this.bitcoin = bitcoin;
        // this.dollar = 0;
        this.i = i;
        return this;
    }

    public String getBitcoin() {
        return bitcoin;
    }

    public int getDollar() {
        return dollar;
    }

    public int getI() {
        return i;
    }


    public void setDollar(int dollar) {
        this.dollar = dollar;
    }

    public void setBitcoin(String bitcoin) {
        this.bitcoin = bitcoin;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Customer withBalance(int i) {
        this.setDollar(i);
        return this;
    }

    @Override
    public String toString() {
        if(this.bitcoin != null){
            return  dollar+":$," + i + ":" + bitcoin;
        }
        return dollar+":$" ;
    }

}
