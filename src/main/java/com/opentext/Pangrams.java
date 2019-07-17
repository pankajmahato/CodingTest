package com.opentext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pangrams {
	private static final Scanner scanner = new Scanner(System.in);





	public static void main(String[] args) throws IOException {

		int stringsCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] strings = new String[stringsCount];

		for (int i = 0; i < stringsCount; i++) {
			String stringsItem = scanner.nextLine();
			strings[i] = stringsItem;
		}

		String res = isPangram(strings);

		System.out.println(res);

		scanner.close();
	}





	static String isPangram(String[] strings) {
		String result = "";
		Map<String, Boolean> map = new HashMap<>();

		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings[i].length(); j++) {
				if (strings[i].charAt(j) != ' ') {
					map.put(String.valueOf(strings[i].charAt(j)), true);
				}
				if (map.size() == 26) {
					break;
				}
			}
			if (map.size() == 26) {
				result += "1";
			} else {
				result += "0";
			}
			map.clear();
		}
		return result;

	}
}
