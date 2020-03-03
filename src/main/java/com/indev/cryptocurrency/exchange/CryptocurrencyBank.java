package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<String> supportedCryptoCurrencies;

    public List<String> getSupportedCryptoCurrencies() {
        return supportedCryptoCurrencies;
    }

    public void setSupportedCryptoCurrencies(List<String> supportedCryptoCurrencies) {
        this.supportedCryptoCurrencies = supportedCryptoCurrencies;
    }

    public CryptocurrencyBank() {
        supportedCryptoCurrencies= new ArrayList<>();
    }

    public void addSupportedCryptoCurrency(String bitcoin) {
        supportedCryptoCurrencies.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
    }
}
