package com.hackerrank.stack;

public class Puzzle {

	public static void main(String[] args) {

		int num = 630;

		int r = 0;
		int n = num;
		int sum = 0;
		while (n > 0) {
			r = n % 10;
			switch (r) {
			//			case 1:
			//			case 2:
			//			case 3:
			//			case 5:
			//			case 7:
			//				sum=sum+1;break;
			case 0:
			case 4:
			case 6:
			case 9:
				sum = sum + 1;
				break;
			case 8:
				sum = sum + 2;
				break;
			}
			n = n / 10;
		}
		System.out.println(sum);
	}
}
