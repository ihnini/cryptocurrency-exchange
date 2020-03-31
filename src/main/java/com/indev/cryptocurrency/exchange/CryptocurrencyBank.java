package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<String> supportedCryptoCurrency = new ArrayList<>();
    private List<Customer> sellerCustomers = new ArrayList<>();

    public CryptocurrencyBank() {
    }

    public List<String> getSupportedCryptoCurrency() {
        return supportedCryptoCurrency;
    }

    public void setSupportedCryptoCurrency(List<String> supportedCryptoCurrency) {
        this.supportedCryptoCurrency = supportedCryptoCurrency;
    }

    public List<Customer> getSellerCustomers() {
        return sellerCustomers;
    }

    public void setSellerCustomers(List<Customer> sellerCustomers) {
        this.sellerCustomers = sellerCustomers;
    }

    public void addSupportedCryptoCurrency(String cryptoCurrency) {
        supportedCryptoCurrency.add(cryptoCurrency);
    }

    public int requestTransaction(Customer buyerCustomer, int cryptoCurrencyAmount, String cryptoCurrency) {

        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        sellerCustomers.add(sellerCustomer);
    }
}
