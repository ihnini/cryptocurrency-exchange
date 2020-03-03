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
        System.out.println("ths crypto is: "+CryptoFactory.getCryptocurrency(bitcoin).toString());
        cryptos.add(CryptoFactory.getCryptocurrency(bitcoin));
    }
    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {

        if(customers.size()==0){
            System.out.println("No seller exist");
            return 0;
        }

        for(ICrypto c : cryptos){
            if(c instanceof Bitcoin && bitcoin=="Bitcoin")
                break;

            if(c instanceof Ethereum && bitcoin=="Ethereum")
                break;

            System.out.println("Crypto does not exist");
            return 0;
        }

            Customer seller;
            for (Customer c : customers.keySet()) {
                if (c.getWallet().getCrypto().toString().equals(bitcoin) && c.getWallet().getCount() >= i) {
                    //seller = c;
                    if(buyerCustomer.getBalance()<calculPrice(customers.get(c)+1)*i){
                        System.out.println("we can't buy with that balance");
                        return 0;
                    }

                    customers.replace(c,customers.get(c)+1);

                    //Counting the price of the cryptocurrency
                    int countPrice;
                    System.out.println("customer numbre : "+ customers.get(c));
                    if(customers.get(c)==1)
                        countPrice=1;
                    else countPrice=customers.get(c)*customers.get(c)-1;
                    System.out.println("price : "+ countPrice);
                    //--------------------
                    //Reducing the balance of the buyer
                    buyerCustomer.setBalance(buyerCustomer.getBalance()-countPrice*i);

                    //Changing the balance of the seller by adding countPrice multiplying by i
                    c.setBalance(c.getBalance()+countPrice*i);

                    //Reducing the seller's crypto number
                    c.getWallet().setCount(c.getWallet().getCount()-i);

                    //Creating a new wallet for the buyer and adding our cryptocurrency and the number
                    Wallet buyerWallet = new Wallet(CryptoFactory.getCryptocurrency(bitcoin),i);

                    buyerCustomer.setWallet(buyerWallet);
                    System.out.println("buyer:"+buyerCustomer.toString());
                    System.out.println("Seller"+c.toString());

                    return i;



                }
            }



        return i;

    }

    public void addSeller(Customer sellerCustomer) {
        customers.put(sellerCustomer,0);
        //cryptos.add(sellerCustomer.getWallet().getCrypto());
        System.out.println(customers);
    }

    public int calculPrice(int i){
        if(i==1)
            return 1;
        return i*i-1;
    }
}
