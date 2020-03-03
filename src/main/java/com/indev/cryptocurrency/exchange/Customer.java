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
	
	// helper functions
	
	public boolean hasGivenQuantityOfCurency(int quantity, String bitcoin){
		return bitcoin.equals(wallet.getCryptoCurency())
				&& 
			   quantity<=wallet.getCryptoCurencyCount();
	}
	
	// toString

	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
						  appendBalance(sb);
		if(hasCurrency()) appendCurrencyAndItsCount(sb);
		return sb.toString();
	}

	private void appendBalance(StringBuilder sb) {
		sb.append(wallet.getBalance()).append(":$");
	}

	private void appendCurrencyAndItsCount(StringBuilder sb) {
		sb.append(",")
		.append(wallet.getCryptoCurencyCount())
		.append(":")
		.append(wallet.getCryptoCurency());
	}

	private boolean hasCurrency() {
		return wallet.getCryptoCurency()!=null;
	}

	

}
