package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CryptocurrencyBank {
    Set<CryptoCurrency> cryptoCurrencies=new HashSet<>();
    List<Customer> sellers=new ArrayList<>();
    List<Customer> buyers=new ArrayList<>();

    public void addSupportedCryptoCurrency(String bitcoin) {
        CryptoCurrency cryptoCurrency=new CryptoCurrency();
        cryptoCurrency.setName(bitcoin);
        cryptoCurrencies.add(cryptoCurrency);
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }

    public void addBuyer(Customer buyerCustomer) {
        buyers.add(buyerCustomer);
    }


    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin){
        boolean SellerExist=false;
        int sellerIndex=0;
        this.addBuyer(buyerCustomer);
        int cryptoCurrencyPrice=defineCryptoCurrncyPrice(this.buyers.size());
        while (!SellerExist && sellerIndex<this.sellers.size()) {
            if (this.sellers.get(sellerIndex).getCryptoCurrency().getName().equals(bitcoin)
                   && sellers.get(sellerIndex).getCryptoCurrency().getQuantite() >= i) {
                SellerExist = true;
            }else
                sellerIndex++;
        }
        if (!SellerExist)
            return 0;
        else {
            sellers.get(sellerIndex).setCryptoCurrency(new CryptoCurrency(bitcoin,sellers.get(sellerIndex).getCryptoCurrency().getQuantite()-i));
            sellers.get(sellerIndex).setBalance(sellers.get(sellerIndex).getBalance()+i*cryptoCurrencyPrice);
            buyerCustomer.setCryptoCurrency(new CryptoCurrency(bitcoin,i));
            buyerCustomer.setBalance(buyerCustomer.getBalance()-i*cryptoCurrencyPrice);
            return i;
        }
    }

    public int defineCryptoCurrncyPrice(int buyersNumber) {
        if(buyersNumber==1)
            return 1;
        else if (buyersNumber>1)
            return (int) (Math.pow(buyersNumber,2)-buyersNumber);
        else
            return 0;
    }
}
