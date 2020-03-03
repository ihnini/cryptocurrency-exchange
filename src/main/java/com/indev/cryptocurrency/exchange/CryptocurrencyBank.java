package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {
    private List<String> supportedCryptocurrencies;
    private List<Customer> sellersCustomers;

    public CryptocurrencyBank(){
        this.supportedCryptocurrencies = new ArrayList<>();
        this.sellersCustomers=new ArrayList<>();
    }

    public void addSupportedCryptoCurrency(String cryptocurrency) {
       supportedCryptocurrencies.add(cryptocurrency);
    }

    public int requestTransaction(Customer buyerCustomer, int quantity, String cryptocurrency) {
        Customer sellerCustomer = getASellerOfACryptocurrency(cryptocurrency);
        if (sellerCustomer != null) {
            buyerCustomer.buy(cryptocurrency,quantity);
            sellerCustomer.sell(quantity);
            return quantity;
        }
        return 0;
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
