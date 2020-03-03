package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CryptocurrencyBank {
    Set<CryptoCurrency> cryptoCurrencies=new HashSet<>();
    Set<Customer> sellers=new HashSet<>();

    public void addSupportedCryptoCurrency(String bitcoin) {
        CryptoCurrency cryptoCurrency=new CryptoCurrency();
        cryptoCurrency.setName(bitcoin);
        cryptoCurrencies.add(cryptoCurrency);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        boolean SellerExist=false;
        for (Customer seller:sellers) {
            if (seller.getCryptoCurrency().getName().equals(bitcoin) && seller.getCryptoCurrency().getQuantite() >= i) {
                SellerExist = true;
                break;
            }
        }
        if (SellerExist)
            return i;
        else
            return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }

}
