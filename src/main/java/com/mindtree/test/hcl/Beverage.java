package com.mindtree.test.hcl;

public class Beverage {

	private int ounces = 12;
	boolean carbonated = false;





	public static void main(String[] args) {
		System.out.println(new SodaPop());
	}

}

class SodaPop extends Beverage {
	@Override
	public String toString() {
		return null;
//		return ounces + " " + carbonated;

	}
}