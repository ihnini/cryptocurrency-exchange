package com.indev.cryptocurrency.exchange;

public class Cryptocurrency {
    private String type;
    private int qte;

    public Cryptocurrency() {
    }

    public Cryptocurrency(String type, int qte) {

        this.type = type;
        this.qte = qte;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
