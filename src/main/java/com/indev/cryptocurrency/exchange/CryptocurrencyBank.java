package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CryptocurrencyBank {
    List<String> cryptocurrencies = new ArrayList<>();
    List<Customer> buyers = new ArrayList<>();
    List<Customer> sellers = new ArrayList<>();

    public void addSupportedCryptoCurrency(String bitcoin)  {
            cryptocurrencies.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        buyers.add(buyerCustomer);
        if(sellers.size() == 0) return 0;
        int price = 1;
        if(buyers.size()>1)
            price = (int)Math.pow(buyers.size(),2) - buyers.size();
        for (Customer s : sellers){
            if (s.getCryptocurrency().getType().equals(bitcoin))
                if(s.getCryptocurrency().getQte()>=i){
                    s.setBalance(s.getBalance()+i*price);
                    s.getCryptocurrency().setQte(s.getCryptocurrency().getQte()-i);
                    buyerCustomer.setBalance(buyerCustomer.getBalance()-i*price);
                    buyerCustomer.setCryptocurrency(new Cryptocurrency(bitcoin,i));
                    return i;
                }
                }
            return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }


    private boolean checkType(String bitcoin)  {
        if(cryptocurrencies.contains(bitcoin)== false) return false;
        return true;
    }
}
