package com.indev.cryptocurrency.exchange;

public class CryptoCurrency {
    private String type;
    private int quantity;
    private int price;

    public CryptoCurrency(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
        this.price = 1;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
