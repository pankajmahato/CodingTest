package com.zolo;

import java.util.Scanner;

public class SmallestPalindrome {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int x = Integer.parseInt(scanner.nextLine());

		while (x < 10000) {
			x++;
			if (isPalindrome(x)) {
				System.out.println(x);
				break;
			}
		}

		scanner.close();
	}





	private static boolean isPalindrome(int x) {
		int r, sum = 0, n;

		n = x;
		while (n > 0) {
			r = n % 10; //getting remainder
			sum = sum * 10 + r;
			n = n / 10;
		}

		return sum == x;
	}
}
