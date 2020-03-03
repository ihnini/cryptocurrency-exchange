package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CryptocurrencyBank {
    Set<CryptoCurrency> cryptoCurrencies=new HashSet<>();
    List<Customer> sellers=new ArrayList<>();

    public void addSupportedCryptoCurrency(String bitcoin) {
        CryptoCurrency cryptoCurrency=new CryptoCurrency();
        cryptoCurrency.setName(bitcoin);
        cryptoCurrencies.add(cryptoCurrency);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        boolean SellerExist=false;
        int sellerIndex=0;
        while (!SellerExist && sellerIndex<this.sellers.size()) {
            if (this.sellers.get(sellerIndex).getCryptoCurrency().getName().equals(bitcoin)
                   && sellers.get(sellerIndex).getCryptoCurrency().getQuantite() >= i) {
                SellerExist = true;
                break;
            }
            sellerIndex++;
        }
        if (!SellerExist)
            return 0;
        else {
            sellers.get(sellerIndex).setCryptoCurrency(new CryptoCurrency(bitcoin,sellers.get(sellerIndex).getCryptoCurrency().getQuantite()-i));
            sellers.get(sellerIndex).setBalance(sellers.get(sellerIndex).getBalance()+i);
            buyerCustomer.setCryptoCurrency(new CryptoCurrency(bitcoin,i));
            buyerCustomer.setBalance(buyerCustomer.getBalance()-i);
            return i;
        }
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }

}
