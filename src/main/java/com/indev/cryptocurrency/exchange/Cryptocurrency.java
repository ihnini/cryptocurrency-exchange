package com.indev.cryptocurrency.exchange;

public class Cryptocurrency {

    private String  name;
    private int balance;
    private int price = 1;
    private int num_buyers = 0;

    public Cryptocurrency(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    public Cryptocurrency() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum_buyers() {
        return num_buyers;
    }

    public void setNum_buyers(int num_buyers) {
        this.num_buyers = num_buyers;
    }
}
