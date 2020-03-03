package com.indev.cryptocurrency.exchange;

import java.util.HashSet;
import java.util.Set;

public class CryptocurrencyBank {
	Set<String> supportedCryptoCurrenciesSet= new HashSet<String>();
	Set<Customer> clients = new HashSet<Customer>();
	
    public void addSupportedCryptoCurrency(String bitcoin) {
    	supportedCryptoCurrenciesSet.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
    	if(clients.contains(sellerCustomer)) {
    		System.out.println("Ce client existe déjà");
    		return;
    	}
    	clients.add(sellerCustomer);
    }
}
