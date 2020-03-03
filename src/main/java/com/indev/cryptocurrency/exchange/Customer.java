package com.indev.cryptocurrency.exchange;

public class Customer {

    private CryptoCurrency cryptoCurrency;
    private int balance;

    public Customer withCryptocurrency(String bitcoin, int quantity) {
        this.cryptoCurrency = new CryptoCurrency(bitcoin,quantity);
        return this;
    }

    public Customer withBalance(int i) {
        this.balance = i;
        return this;
    }

    @Override
    public String toString() {
        return printBalance() + printCryptocurrencyTypeAndQuantity();
    }

    private String printCryptocurrencyTypeAndQuantity() {
        if (cryptoCurrency != null) {
            return "," + cryptoCurrency.getQuantity() + ":" + cryptoCurrency.getType();
        }
        return "";
    }

    private String printBalance() {
        return balance + ":$";
    }

    public String getTypeOfCustemerCryptoCurrency() {
        return cryptoCurrency.getType();
    }

    public void buy(String bitcoin,int quantity) {
        if (isCustmorHasNoCryptoCurrency()){
            this.withCryptocurrency(bitcoin,0);
        }
        decreaseBalance(quantity);
        increaseCryptoCurrencyQuantity(quantity);
    }

    private boolean isCustmorHasNoCryptoCurrency() {
        return cryptoCurrency == null;
    }

    public void sell(int quantity) {
        increaseBalance(quantity);
        decreaseCryptoCurrencyQuantity(quantity);
    }

    private void decreaseCryptoCurrencyQuantity(int quantity) {
        cryptoCurrency.decreaseQuantity(quantity);
    }

    private void increaseCryptoCurrencyQuantity(int quantity) {
        cryptoCurrency.increaseQuantity(quantity);
    }

    private void increaseBalance(int quantity) {
        this.balance += totalPrice(quantity);
    }
    private void decreaseBalance(int quantity) {
        this.balance -= totalPrice(quantity);
    }

    private int totalPrice(int quantity) {
        return quantity * cryptoCurrency.getPrice();
    }


}
