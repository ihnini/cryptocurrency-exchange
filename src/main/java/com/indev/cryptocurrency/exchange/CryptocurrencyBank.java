package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

import com.sun.deploy.security.WSeedGenerator;

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
        if (sellerCustomers.size() == 0 || !(cryptoCurrency.equals(sellerCustomers.get(0).getCryptoCurrency()))) {
            return 0;
        }
        buyerCustomer.setBalance(buyerCustomer.getBalance() - cryptoCurrencyAmount);
        buyerCustomer.setCryptoCurrency(cryptoCurrency);
        buyerCustomer.setCryptoCurrencyAmount(buyerCustomer.getCryptoCurrencyAmount() + cryptoCurrencyAmount);
        Customer sellerCustomer = sellerCustomers.get(0);
        sellerCustomer.setCryptoCurrencyAmount(sellerCustomer.getCryptoCurrencyAmount() - cryptoCurrencyAmount);
        sellerCustomer.setBalance(sellerCustomer.getBalance() + cryptoCurrencyAmount);
        return cryptoCurrencyAmount;
    }

    public void addSeller(Customer sellerCustomer) {
        sellerCustomers.add(sellerCustomer);
    }
}
