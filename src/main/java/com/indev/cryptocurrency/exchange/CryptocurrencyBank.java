package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;

public class CryptocurrencyBank {

    private ArrayList<String> supportedCryptoCurrency;
    private ArrayList<Customer> customers;


    public CryptocurrencyBank() {
        supportedCryptoCurrency = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addSupportedCryptoCurrency(String cryptoCurrency) {
        supportedCryptoCurrency.add(cryptoCurrency);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String cryptoCurrency) {
        for (Customer customer:customers) {

            if(customer.getCryptoCurrency().equals(cryptoCurrency) && customer.getQuantity()>=i){
                customer.setBalance(customer.getBalance()+i);
                customer.setQuantity(customer.getQuantity()-i);

                buyerCustomer.setCryptoCurrency(cryptoCurrency);
                buyerCustomer.setQuantity(buyerCustomer.getQuantity()+i);
                buyerCustomer.setBalance(buyerCustomer.getBalance()-i);
                return i;
            }
        }
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        this.customers.add(sellerCustomer);
    }

    public ArrayList<String> getSupportedCryptoCurrency() {
        return supportedCryptoCurrency;
    }

    public void setSupportedCryptoCurrency(ArrayList<String> supportedCryptoCurrency) {
        this.supportedCryptoCurrency = supportedCryptoCurrency;
    }
}
