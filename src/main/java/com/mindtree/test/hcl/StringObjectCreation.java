package com.mindtree.test.hcl;

public class StringObjectCreation {
	public static void main(String args[]) {

		String str1 = "Hello";
		String str2 = "Hello";
		String str3 = new String("Hello");
		String str4 = new String("Hello");

		if (str1 == str2) {
			System.out.println("Equal 1");
		} else {
			System.out.println("Not equal 1");
		}
		if (str1 == str3) {
			System.out.println("Equal 2");
		} else {
			System.out.println("I am constructed using constructor");
		}
		if (str1.equals(str3)) {
			System.out.println("Equal 3");
		} else {
			System.out.println("Not Equal 3");
		}
		if (str3 == str4) {
			System.out.println("Equal 4");
		} else {
			System.out.println("Not equal 4");
		}
	}
}
