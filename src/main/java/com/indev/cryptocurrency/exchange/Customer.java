package com.indev.cryptocurrency.exchange;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private Map<String, Integer> currs = new HashMap<>();

    private int balance = 0;

    public Customer withCryptocurrency(String bitcoin, int i) {
        currs.put(bitcoin, i);
        return this;
    }

    public Customer withBalance(int i) {
        balance = i;
        return this;
    }

    public Map<String, Integer> getCurrs() {
        return currs;
    }

    public int getBalance() {
        return balance;
    }

    // If type = 0 it means subtract the value, if it's one that means add the value
    public void updateBalance(int value, int type) {
        if (type == 0) {
            balance -= value;
        } else {
            balance += value;
        }
    }

    public void updateCurr(int value, String bitcoin, int type) {
        if (currs.get(bitcoin) == null)
            withCryptocurrency(bitcoin, 0);
        if (type == 0)
            currs.put(bitcoin, currs.get(bitcoin) - value);
        else
            currs.put(bitcoin, currs.get(bitcoin) + value);
    }

    @Override
    public String toString() {
        String s = "";
        for (Map.Entry<String, Integer> entry : currs.entrySet())
            s += ("," + entry.getValue() + ":" + entry.getKey());
        return balance + ":$" + s;
    }
}
