package com.indev.cryptocurrency.exchange;

public class Wallet {
    private ICrypto crypto;
    private int count = 0;

    public Wallet() {
    }

    public Wallet(ICrypto crypto, int count) {
        this.crypto = crypto;
        this.count = count;
    }

    public ICrypto getCrypto() {
        return crypto;
    }

    public void setCrypto(ICrypto crypto) {
        this.crypto = crypto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
