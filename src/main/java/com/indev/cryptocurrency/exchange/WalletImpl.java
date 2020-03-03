package com.indev.cryptocurrency.exchange;

public class WalletImpl implements Wallet {
	private String cryptoCurency="";
	private int cryptoCurencyCount=0;
	private int balance=0;
	
	// Getters and setters
    
		public String getCryptoCurency() {
			return cryptoCurency;
		}

		public void setCryptoCurency(String cryptoCurency) {
			this.cryptoCurency = cryptoCurency;
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}
		
		public int getCryptoCurencyCount() {
			return cryptoCurencyCount;
		}

		public void setCryptoCurencyCount(int cryptoCurencyCount) {
			this.cryptoCurencyCount = cryptoCurencyCount;
		}
		
}
