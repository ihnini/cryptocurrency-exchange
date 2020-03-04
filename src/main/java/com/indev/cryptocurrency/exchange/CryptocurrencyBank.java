package com.indev.cryptocurrency.exchange;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CryptocurrencyBank {
    public Set<ICrypto> cryptos = new HashSet<>();
    public Map<Customer,Integer> customers = new HashMap<>();

    public void addSupportedCryptoCurrency(String bitcoin) {
        System.out.println("from addSupportedCryptoCurrency : the crypto is: "+CryptoFactory.getCryptocurrency(bitcoin).toString());
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

            for (Customer c : customers.keySet()) {
                if (c.getWallet().getCrypto().toString().equals(bitcoin) && c.getWallet().getCount() >= i) {
                    if(buyerCustomer.getBalance()< priceCounting(customers.get(c)+1)*i){
                        System.out.println("we can't buy with that balance");
                        return 0;
                    }

                    customers.replace(c,customers.get(c)+1);

                    //Reducing the balance of the buyer
                    buyerCustomer.setBalance(buyerCustomer.getBalance()-priceCounting(customers.get(c))*i);

                    //Changing the balance of the seller by adding countPrice multiplying by i
                    c.setBalance(c.getBalance()+priceCounting(customers.get(c))*i);

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
        System.out.println(customers);
    }

    public int priceCounting(int i){
        if(i==1)
            return 1;
        return i*i-i;
    }
}
