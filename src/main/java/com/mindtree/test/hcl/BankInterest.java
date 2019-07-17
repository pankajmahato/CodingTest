package com.mindtree.test.hcl;

public class BankInterest {
	public static void main(String args[]) {
		System.out.println(showInterest(new SBI()));
		System.out.println(showInterest(new ICICI()));
		System.out.println(showInterest(new AXIS()));
	}





	public static Number showInterest(Bank bank) {
		return bank.getRateOfInterest();
	}
}

class Bank {
	float getRateOfInterest() {
		return 0;
	}
}

class SBI extends Bank {
	@Override
	float getRateOfInterest() {
		return 8.4f;
	}
}

class ICICI extends Bank {
	@Override
	float getRateOfInterest() {
		return 7.3f;
	}
}

class AXIS extends Bank {
	@Override
	float getRateOfInterest() {
		return 9.7f;
	}
}