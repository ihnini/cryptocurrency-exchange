package com.indev.cryptocurrency.exchange;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {
    List<String> listCryptoCurrency = new ArrayList<String>();
    List<Customer> listCustmer = new ArrayList<Customer>();
    int nbrOfBuyer = 0;
    public CryptocurrencyBank(){

    }
    public void addSupportedCryptoCurrency(String bitcoin) {
        listCryptoCurrency.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
    int cof = 1;
    nbrOfBuyer ++;
    if(nbrOfBuyer > 1) {
        cof = (int) Math.pow(nbrOfBuyer,2) - nbrOfBuyer;
    }
        for (Customer c:listCustmer) {
            if(c.getQuentity() >= i && c.getCurrency().equals(bitcoin)){
                c.setQuentity(c.getQuentity()-i);
                c.setBalance(c.getBalance()+i*cof);

                buyerCustomer.setCurrency(bitcoin);
                buyerCustomer.setQuentity(buyerCustomer.getQuentity()+i);
                buyerCustomer.setBalance(buyerCustomer.getBalance()-i*cof);
                return i;
            }
        }
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        listCustmer.add(sellerCustomer);
    }
}
