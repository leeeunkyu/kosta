package com.kosta.j0816;

public class Account {//모금함(저금통)
	private int total;
	
	public synchronized void deposit(int account) {
		total += account; // total = total+account
	}//deposit

	public int getTotal() {
		return total;
	}
}