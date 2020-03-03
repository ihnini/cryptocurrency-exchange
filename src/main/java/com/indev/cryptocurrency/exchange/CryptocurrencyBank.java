package com.indev.cryptocurrency.exchange;

import org.apache.tomcat.util.bcel.Const;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<String> supportedCryptoCurrencies;
    private List<Customer> sellerCustomers;
    private int nbr_buyer = 0;

    public CryptocurrencyBank() {
        this.supportedCryptoCurrencies = new ArrayList<>();
        this.sellerCustomers = new ArrayList<>();
    }

    public void addSupportedCryptoCurrency(String bitcoin) {
        this.supportedCryptoCurrencies.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        int base_price = 1;
        nbr_buyer++;
        ///// if number of users more than 1;
        if (nbr_buyer > 1) {
            base_price = (int) Math.pow(nbr_buyer, 2) - nbr_buyer;
        }
        ///// if exist sellers !
        if (sellerCustomers != null && !sellerCustomers.isEmpty()) {
            for (Customer customer : sellerCustomers) {
        ///// if customer can sell
                if (customer.getWallet() > i && customer.getCryptocurrency().equals(bitcoin)) {
                    customer.setBalance(customer.getBalance() + i * base_price);
                    customer.setWallet(customer.getWallet() - i);
                    buyerCustomer.setWallet(buyerCustomer.getWallet() + i);
                    buyerCustomer.setBalance(buyerCustomer.getBalance() - i * base_price);
                    buyerCustomer.setCryptocurrency(bitcoin);
                    return i;
                }
            }
        }
        return 0;
    }


    public void addSeller(Customer sellerCustomer) {
        if (sellerCustomers != null) {
            this.sellerCustomers.add(sellerCustomer);
        }
    }
}
