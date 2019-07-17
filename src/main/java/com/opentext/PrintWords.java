package com.opentext;

import java.io.IOException;
import java.util.Scanner;

public class PrintWords {


	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


		String stringsItem = scanner.nextLine();

		String[] data = stringsItem.split(" ");

		int count = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i].indexOf('t') == -1) {
			} else if ((data[i].indexOf('t') + 1) % 2 == 0) {
				System.out.println(data[i]);
				count++;
			} else if ((data[i].indexOf('t') + 1) % 2 != 0) {
				System.out.println(reverse(data[i]));
				count++;
			}
		}
		if (count == 0) {
			System.out.println("None");
		}

		scanner.close();
	}





	public static String reverse(String str) {

		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

}
