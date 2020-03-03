package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {
    private List<String> supportedCryptocurrencies;
    private List<Customer> sellersCustomers;
    private int numberOfBuyers=0;

    public CryptocurrencyBank(){
        this.supportedCryptocurrencies = new ArrayList<>();
        this.sellersCustomers=new ArrayList<>();
    }

    public void addSupportedCryptoCurrency(String cryptocurrency) {
       supportedCryptocurrencies.add(cryptocurrency);
    }

    public int requestTransaction(Customer buyerCustomer, int quantity, String cryptocurrency) {
        Customer sellerCustomer = getASellerOfACryptocurrency(cryptocurrency);
        if (cryptoCurrencyHasNoSeller(sellerCustomer)) {
            numberOfBuyers++;
            buyerCustomer.buy(cryptocurrency,quantity,numberOfBuyers);
            sellerCustomer.sell(quantity,numberOfBuyers);
            return quantity;
        }
        return 0;
    }

    private boolean cryptoCurrencyHasNoSeller(Customer sellerCustomer) {
        return sellerCustomer != null;
    }

    private Customer getASellerOfACryptocurrency(String cryptocurrency) {
        for (Customer seller: sellersCustomers) {
            if (seller.getTypeOfCustemerCryptoCurrency().equals(cryptocurrency)){
                return seller;
            }
        }
        return null;
    }

    public void addSeller(Customer sellerCustomer) {
        sellersCustomers.add(sellerCustomer);
    }
}
