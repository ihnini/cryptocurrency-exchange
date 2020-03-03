package com.indev.cryptocurrency.exchange;

public class CryptoCurrency {
    private String name;
    private int quantite;

    public CryptoCurrency() {
    }

    public CryptoCurrency(String name, int quantite) {
        this.name = name;
        this.quantite = quantite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return this.getQuantite()+":"+this.getName();
    }
}
