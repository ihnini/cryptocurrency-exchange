package com.indev.cryptocurrency.exchange;

public interface Wallet {
	// Getters and setters
    
		public String getCryptoCurency();

		public void setCryptoCurency(String cryptoCurency);

		public int getBalance();

		public void setBalance(int balance);
		
		public int getCryptoCurencyCount();

		public void setCryptoCurencyCount(int cryptoCurencyCount);
		
}
