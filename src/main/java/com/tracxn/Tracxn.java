package com.tracxn;

import java.util.Scanner;

public class Tracxn {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String pattern = scanner.nextLine();

		boolean success = true;
		boolean alreadyFound = false;
		int start = 0;
		int end = 0;
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == '^') {
				if (!alreadyFound) {
					start = i;
					alreadyFound = true;
				} else {
					alreadyFound = false;
				}
			} else {
				if (alreadyFound) {
					for (int j = start; j < input.length(); j++) {
						if (input.charAt(j) == pattern.charAt(i)) {
							end = j;
							break;
						}
					}
					if (!isPrime(end - start)) {
						success = false;
					}
					alreadyFound = false;
				}
			}
		}

		if (success) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

		//		int n = 34;
		//		for (int i = 2; i <= n / 2; ++i) {
		//			if (isPrime(i)) {
		//				if (isPrime(n - i)) {
		//					System.out.println(i + "  " + (n - i));
		//				}
		//
		//			}
		//		}

		scanner.close();
	}





	private static boolean isPrime(long n) {
		if (n < 2) {
			return false;
		}
		if (n == 2 || n == 3) {
			return true;
		}
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0) {
				return false;
			}
		}
		return true;
	}

}
