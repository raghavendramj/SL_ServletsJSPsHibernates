package com.simpilearn.model;

public class ICICIBank implements Bank {

	public double withDraw() {
		System.out.println("Withdraw method of ICIC Bank");
		return 0;
	}

	public double balance() {
		System.out.println("balance method of ICIC Bank");
		return 0;
	}

	public void deposit() {
		System.out.println("deposit method of ICIC Bank");
	}
}
