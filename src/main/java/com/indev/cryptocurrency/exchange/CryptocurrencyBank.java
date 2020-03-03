package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    List<String> SupportedCryptoCurrency ;
    List<Customer> Sellers ;
    int numberOfBuyers = 1;
    int priceofSelling = 1;

    public CryptocurrencyBank() {
        SupportedCryptoCurrency = new ArrayList<String>();
        Sellers = new ArrayList<Customer>();
    }

    public void addSupportedCryptoCurrency(String bitcoin) {
        SupportedCryptoCurrency.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        int boughtQuantity = 0;
        if(numberOfBuyers>1) priceofSelling = numberOfBuyers*numberOfBuyers - numberOfBuyers;
        for(Customer seller : Sellers){
            if(i <= 0) break;
            if(seller.bitcoin.equals(bitcoin) && seller.quantity > 0){
                int actual_trans = (i<=seller.quantity) ? i : seller.quantity;
                if(buyerCustomer.balance >= actual_trans*priceofSelling){
                    seller.withCryptocurrency(bitcoin,-1* actual_trans).withBalance(actual_trans*priceofSelling);
                    buyerCustomer.withCryptocurrency(bitcoin,actual_trans).withBalance(-1*actual_trans*priceofSelling);
                    i -= actual_trans;
                    boughtQuantity +=actual_trans;
                }
            }
        }
        numberOfBuyers++;
        return boughtQuantity;
    }

    public void addSeller(Customer sellerCustomer) {
        Sellers.add(sellerCustomer);
    }
}
