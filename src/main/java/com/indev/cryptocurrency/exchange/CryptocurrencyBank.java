package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<String> CryptoCurrency ;
    private List<Customer> ListSeller = new ArrayList<>() ;
    private int buyer = 0;

    public CryptocurrencyBank (){
        CryptoCurrency = new ArrayList<String>();
    }

    public void addSupportedCryptoCurrency(String bitcoin) {
        CryptoCurrency.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        int price = 1;
        buyer ++;
        if(buyer > 1)
            price = (int) Math.pow(buyer,2) - buyer;

        if(ListSeller.size() == 0)
           return 0;
        else{
            for (Customer seller : ListSeller) {
                if (seller.getWallet() >= i && seller.getCryptocurrency().equals(bitcoin)){
                    buyerCustomer.setBalance(buyerCustomer.getBalance()-i * price);
                    buyerCustomer.setCryptocurrency(bitcoin);
                    buyerCustomer.setWallet(buyerCustomer.getWallet() + i);

                    seller.setBalance(seller.getBalance() + i*price);
                    seller.setCryptocurrency(bitcoin);
                    seller.setWallet(seller.getWallet() - i);
                    return i ;
                }else
                    return 0 ;

            }
        }
       return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        ListSeller.add(sellerCustomer) ;
    }
}
