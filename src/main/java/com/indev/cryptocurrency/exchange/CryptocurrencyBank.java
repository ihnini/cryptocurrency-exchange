package com.indev.cryptocurrency.exchange;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CryptocurrencyBank {
    public Set<ICrypto> cryptos = new HashSet<>();
    //public Set<String> cryptos = new HashSet<>();
    public Map<Customer,Integer> customers = new HashMap<>();

    public void addSupportedCryptoCurrency(String bitcoin) {
    }
    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        /*

        Customer buyerCustomer = new Customer().withBalance(100);
        int boughtQuantity = cryptocurrencyBank.requestTransaction(buyerCustomer, 3, "Bitcoin");

         */

        if(customers==null){
            System.out.println("BuyerCustomer does not exist");
            return 0;
        }

        /*Boolean existCrypto=false;

        for(Customer c : customers.keySet()){
            if(c.getWallet().getCrypto().toString().equals(bitcoin)) {
                existCrypto = true;
                break;
            }
        }*/
        /*int cnt=0;
        while(existCrypto=false && cnt<customers.size()){
            if(c.getWallet().getCrypto().toString().equals(bitcoin))
                existCrypto=true;
        }*/
        /*if(existCrypto==false)
            return 0;
        */
        for(ICrypto c : cryptos){
            if(!(c instanceof Bitcoin && bitcoin=="Bitcoin")){
                System.out.println("Crypto does not exist");
                return 0;
            }
        }
        /*if(!cryptos.contains(CryptoFactory.getCryptocurrency(bitcoin))){
            System.out.println("Crypto does not exist");
            return 0;
        } else {*/
            Customer seller;
            for (Customer c : customers.keySet()) {
                if (c.getWallet().getCrypto().toString().equals(bitcoin) && c.getWallet().getCount() >= i) {
                    //seller = c;
                    if(buyerCustomer.getBalance()<calculPrice(customers.get(c)+1)*1){
                        System.out.println("we can't buy with that balance");
                        return 0;}
                    customers.replace(c,customers.get(c)+1);
                    buyerCustomer.setBalance(buyerCustomer.getBalance()-customers.get(c)*i);
                    c.setBalance(c.getBalance()+customers.get(c)*i);
                    c.getWallet().setCount(c.getWallet().getCount()-i);
                    Wallet buyerWallet = new Wallet(CryptoFactory.getCryptocurrency(bitcoin),i);
                    buyerCustomer.setWallet(buyerWallet);
                    return i;

                }
            }



        return 1;

    }

    public void addSeller(Customer sellerCustomer) {
        customers.put(sellerCustomer,0);
        //cryptos.add(sellerCustomer.getWallet().getCrypto());
        cryptos.add(sellerCustomer.getWallet().getCrypto());
        System.out.println("Seller crypto :: "+sellerCustomer.getWallet().getCrypto().toString());
        System.out.println(customers);
    }

    public int calculPrice(int i){
        if(i==1)
            return 1;
        return i*i-1;
    }
}
