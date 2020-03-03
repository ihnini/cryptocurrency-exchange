package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CryptocurrencyBank {
    List<String> cryptocurrencies = new ArrayList<>();
    List<Consumer> consumers = new ArrayList<>();

    public void addSupportedCryptoCurrency(String bitcoin)  {
            cryptocurrencies.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
    }


    private boolean checkType(String bitcoin)  {
        if(cryptocurrencies.contains(bitcoin)== false) return false;
        return true;
    }
}
