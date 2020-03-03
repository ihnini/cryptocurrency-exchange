package com.indev.cryptocurrency.exchange;

public class Customer {
	private Wallet wallet = new WalletImpl();
	
	public Customer withCryptocurrency(String bitcoin, int cryptoCurencyCount) {
    	wallet.setCryptoCurencyCount(cryptoCurencyCount);
    	wallet.setCryptoCurency(bitcoin);
        return this;
    }

    public Customer withBalance(int balance) {
    	wallet.setBalance(balance);
        return this;
    }
   
    // Getters and setters
    
	public String getCryptoCurency() {
		return wallet.getCryptoCurency();
	}

	public void setCryptoCurency(String cryptoCurency) {
		wallet.setCryptoCurency(cryptoCurency);
	}

	public int getBalance() {
		return wallet.getBalance();
	}

	public void setBalance(int balance) {
		wallet.setBalance(balance);
	}
	
	public int getCryptoCurencyCount() {
		return wallet.getCryptoCurencyCount();
	}

	public void setCryptoCurencyCount(int cryptoCurencyCount) {
		wallet.setCryptoCurencyCount(cryptoCurencyCount);
	}
	
	// toString

	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append(wallet.getBalance()).append(":$");
		if(!wallet.getCryptoCurency().isBlank()) sb.append(",").append(wallet.getCryptoCurencyCount()).append(":").append(wallet.getCryptoCurency());
		return sb.toString();
	}
}
