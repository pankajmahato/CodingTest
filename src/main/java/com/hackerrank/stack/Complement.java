package com.hackerrank.stack;

public class Complement {

	public static void main(String[] args) {

		int n = 630;


		char[] binary = Integer.toString(n, 2).toCharArray();
		for (int i = 0; i < binary.length; i++) {
			if (binary[i] == '0') {
				binary[i] = '1';
			} else {
				binary[i] = '0';
			}
		}
		System.out.println(Integer.parseInt(String.valueOf(binary), 2));
	}
}
