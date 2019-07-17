package com.zolo;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

	static int count(int n) {
		int table[] = new int[n + 1], i;

		Arrays.fill(table, 0);

		table[0] = 1;

		for (i = 3; i <= n; i++) {
			table[i] += table[i - 3];
		}
		for (i = 7; i <= n; i++) {
			table[i] += table[i - 7];
		}
		for (i = 14; i <= n; i++) {
			table[i] += table[i - 14];
		}

		return table[n];
	}





	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		System.out.println(count(n));
		scanner.close();
	}
}
