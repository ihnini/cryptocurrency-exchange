package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {
    List<Customer> listCustomer = new ArrayList<Customer>();
    private int nb = 0;


    public void addSupportedCryptoCurrency(String bitcoin) {

    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        nb ++ ;
        int c = 1;
        if(nb > 1){
            c = (int) (Math.pow(nb,2)-nb);
        }
        for(Customer cus: listCustomer){
            if(cus.getI() >= i && cus.getBitcoin().equals(bitcoin)){
                cus.setI(cus.getI()-i);
                cus.setDollar((cus.getDollar()+i*c));

                buyerCustomer.setBitcoin("Bitcoin");
                buyerCustomer.setI(buyerCustomer.getI()+i);
                buyerCustomer.setDollar((buyerCustomer.getDollar()-i*c));
                return i;
            }
        }
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        listCustomer.add(sellerCustomer);
    }

}
