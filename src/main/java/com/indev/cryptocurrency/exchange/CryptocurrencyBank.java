package com.indev.cryptocurrency.exchange;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {
    List<String> listCryptoCurrency = new ArrayList<String>();
    public CryptocurrencyBank(){

    }
    public void addSupportedCryptoCurrency(String bitcoin) {
        listCryptoCurrency.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        buyerCustomer.setCurrency(bitcoin);
        buyerCustomer.setQuentity(i);
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
    }
}
