package com.zolo;

import java.util.Scanner;

public class Cells {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String stringsItem = scanner.nextLine();
		String[] line = stringsItem.split(" ");

		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);

		int[][] data = new int[n][2];

		for (int i = 0; i < n; i++) {
			line = scanner.nextLine().split(" ");
			data[i][0] = Integer.parseInt(line[0]);
			data[i][1] = Integer.parseInt(line[1]);
		}

		//		int current = 0;
		//		while (true) {
		//			int min = Integer.MAX_VALUE;
		//			int minPos = current;
		//			int val = -1;
		//			for (int i = current; i < k && i < n; i++) {
		//				val = data[i][0] * data[i][1];
		//				if (min > val) {
		//					min = val;
		//					minPos = i;
		//				}
		//			}
		//		}

		int[][] temp = new int[n][2];
		int pos = -1;
		for (int i = k - 1; i < n; i += k) {
			pos++;
			temp[pos][0] = data[i][0];
			temp[pos][1] = data[i][1];
		}

		int maxA = Integer.MIN_VALUE;
		int maxB = Integer.MIN_VALUE;
		for (int i = 0; i <= pos; i++) {
			if (maxA < temp[i][0]) {
				maxA = temp[i][0];
			}
			if (maxB < temp[i][1]) {
				maxB = temp[i][1];
			}
		}

		System.out.println(maxA * maxB);

		scanner.close();
	}

}
