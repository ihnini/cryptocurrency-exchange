package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptocurrencyBank {

    List<String> supportedCurrencies = new ArrayList<String>();
    Map<String, Integer> currBuyValues = new HashMap<>();
    List<Customer> seller = new ArrayList<>();

    public CryptocurrencyBank() {
        currBuyValues.put("Bitcoin", 0);
        currBuyValues.put("Ethereum", 0);
    }

    public void addSupportedCryptoCurrency(String bitcoin) {
        supportedCurrencies.add(bitcoin);
    }


    // needs A LOT of refactoring and comments
    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        if (seller.isEmpty()) {
            return 0;
        }

        int amountStored = 0;

        for (Customer c : seller) {
            Map<String, Integer> currs = c.getCurrs();
            if (currs.get(bitcoin) == null || currs.get(bitcoin) == i) {
                continue;
            }
            amountStored += currs.get(bitcoin);
        }

        if (amountStored < i) {
            return 0;
        }

        currBuyValues.put(bitcoin, currBuyValues.get(bitcoin) + 1);
        int n = currBuyValues.get(bitcoin);
        int pay = (int) Math.pow(n, 2) - n;
        if (n <= 1) {
            pay = 1;
        }

        if (buyerCustomer.getBalance() < pay * i) {
            return 0;
        }

        buyerCustomer.updateBalance(pay * i, 0);
        buyerCustomer.updateCurr(i, bitcoin, 1);

        int g = i;
        for (Customer c : seller) {
            Map<String, Integer> currs = c.getCurrs();
            if (currs.get(bitcoin) == null || currs.get(bitcoin) == i) {
                continue;
            }
            if (currs.get(bitcoin) >= i) {
                c.updateBalance(pay * i, 1);
                c.updateCurr(i, bitcoin, 0);
                break;
            } else {
                c.updateBalance(pay * currs.get(bitcoin), 1);
                i -= currs.get(bitcoin);
                currs.remove(bitcoin);
            }
        }

        return g;
    }

    public void addSeller(Customer sellerCustomer) {
        seller.add(sellerCustomer);
    }
}
