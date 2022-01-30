package com.simpilearn.model;

public class HDFCBank implements Bank {

	public double withDraw() {
		System.out.println("Withdraw method of HDFCBank");
		return 0;
	}

	public double balance() {
		System.out.println("balance method of HDFCBank");
		return 0;
	}

	public void deposit() {
		System.out.println("deposit method of HDFCBank");
	}
}
