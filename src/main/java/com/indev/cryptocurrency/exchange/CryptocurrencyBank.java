package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<Customer>  sellers = new ArrayList<Customer>();
    private List<String> cryptos = new ArrayList<String>();


    public void addSupportedCryptoCurrency(String bitcoin) {
            if(!(cryptos.contains(bitcoin)))
                cryptos.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {

        if(sellers.isEmpty() || !(cryptos.contains(bitcoin)) )
            return 0;

        for (Customer seller : sellers) {
                if(seller.getCrypto().getBalance()>i && seller.getCrypto().getName().equals(bitcoin))
                {
                        seller.getCrypto().setBalance(seller.getCrypto().getBalance() - i);
                        buyerCustomer.getCrypto().setBalance(buyerCustomer.getCrypto().getBalance() + i);
                        buyerCustomer.setNameCrypto(bitcoin);

                        seller.getCrypto().setNum_buyers(seller.getCrypto().getNum_buyers() + 1);

                        if(seller.getCrypto().getNum_buyers()>1) {

                                seller.getCrypto().setPrice((int) Math.pow(
                                    seller.getCrypto().getNum_buyers(), 2)
                                    - seller.getCrypto().getNum_buyers());
                            }

                    seller.setBalance(seller.getBalance() +
                        (seller.getCrypto().getPrice()*i)
                    );
                    buyerCustomer.setBalance(buyerCustomer.getBalance() - (seller.getCrypto().getPrice()*i) );

                        return i;
                }
        }

        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
}
