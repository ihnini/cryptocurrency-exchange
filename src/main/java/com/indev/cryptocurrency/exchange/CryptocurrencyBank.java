package com.indev.cryptocurrency.exchange;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class CryptocurrencyBank {
 	private Set<Customer> sellerCustomers = new HashSet<Customer>();
 	private Map<String, Integer> currenciesAndNumberOfBuyers = new HashMap<String, Integer>();
   
	public void addSupportedCryptoCurrency(String bitcoin) {
		currenciesAndNumberOfBuyers.put(bitcoin,0);
    }
    
    public int requestTransaction(Customer buyerCustomer, int quantity, String bitcoin) {
    	currenciesAndNumberOfBuyers.put(bitcoin,currenciesAndNumberOfBuyers.get(bitcoin)+1);
    	//should not buy when there is no seller
    	Optional<Customer> optionalCustomer = currencyIsBeingSoldWithEnoughQuantity(quantity, bitcoin);
    	if(optionalCustomer.isPresent()) {
    		Customer sellerCustomer = optionalCustomer.get();
    		int price= calculatePriceInDollars(bitcoin);
    		//buyer can't buy if they don't have enough balance
    		if(buyerCustomer.getBalance()<price) return 0;
    		//seller
    		sellerCustomer.setCryptoCurencyCount(sellerCustomer.getCryptoCurencyCount()-quantity);
    		sellerCustomer.setBalance(sellerCustomer.getBalance()+quantity*price);
    		//buyer
    		buyerCustomer.setCryptoCurency(bitcoin);
    		buyerCustomer.setCryptoCurencyCount(buyerCustomer.getCryptoCurencyCount()+quantity);
    		buyerCustomer.setBalance(buyerCustomer.getBalance()-quantity*price);
    		
    		return quantity;
    	}
    	return 0;  	
    }

    private int calculatePriceInDollars(String bitcoin) {
    	if(thereIsOnlyOneBuyer(bitcoin)) return 1;
		return getTotalNumberOfBuyersOf(bitcoin)*getTotalNumberOfBuyersOf(bitcoin) - getTotalNumberOfBuyersOf(bitcoin);
	}

	private boolean thereIsOnlyOneBuyer(String bitcoin) {
		return getTotalNumberOfBuyersOf(bitcoin)==1;
	}

	private int getTotalNumberOfBuyersOf(String bitcoin) {
		return currenciesAndNumberOfBuyers.get(bitcoin);
	}
	
	private Optional<Customer> currencyIsBeingSoldWithEnoughQuantity(int quantity, String bitcoin) {
 		return sellerCustomers.stream()
			 	 .filter(c-> c.hasGivenQuantityOfCurency(quantity, bitcoin))
			 			 .findFirst();
	}

	public void addSeller(Customer sellerCustomer) {
    	if(sellerCustomers.contains(sellerCustomer)) {
    		System.out.println("Ce client existe déjà");
    		return;
    	}
    	sellerCustomers.add(sellerCustomer);
    }
}
