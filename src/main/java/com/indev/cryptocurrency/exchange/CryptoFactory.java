package com.indev.cryptocurrency.exchange;

public class CryptoFactory {

    public static ICrypto getCryptocurrency(String cryptocurrency){
        ICrypto crypto = null;
        if(cryptocurrency.equals("Bitcoin"))
            return new Bitcoin();
        if(cryptocurrency.equals("Ethereum"))
            return new Ethereum();
        return crypto;
    }
}
