package com.vicky;

import java.util.Scanner;

public class StringRotate {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String stringsItem = scanner.nextLine();
		String original = stringsItem;

		String newString = "";
		int q = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < q; i++) {
			String rotateString = scanner.nextLine();
			String[] line = rotateString.split(" ");
			String direction = line[0];
			int d = Integer.parseInt(line[1]);
			if (direction.equals("R")) {
				stringsItem = rightrotate(stringsItem, d);
			} else if (direction.equals("L")) {
				stringsItem = leftrotate(stringsItem, d);
			}
			newString += stringsItem.charAt(0);
		}
		boolean result = isSubStringAnagram(original, newString);
		if (result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		scanner.close();
	}





	private static String leftrotate(String s, int d) {
		String part1 = reverse(s.substring(0, d));
		String part2 = reverse(s.substring(d));
		String part3 = part1 + part2;
		return reverse(part3);
	}





	private static String rightrotate(String s, int d) {
		return leftrotate(s, s.length() - d);
	}





	private static String reverse(String s) {
		StringBuilder temp = new StringBuilder();

		temp.append(s);

		return temp.reverse().toString();
	}





	//Two string are considered and check whether Anagram of the second     string is
	//present in the first string as part of it (Substring)
	//e.g. 'atctv' 'cat' will return true as 'atc' is anagram of cat
	//Similarly 'battex' is containing an anagram of 'text' as 'ttex'

	public static boolean isAnagram(String str1, String str2) {
		Character[] charArr = new Character[str1.length()];

		for (int i = 0; i < str1.length(); i++) {
			char ithChar1 = str1.charAt(i);
			charArr[i] = ithChar1;
		}
		for (int i = 0; i < str2.length(); i++) {
			char ithChar2 = str2.charAt(i);
			for (int j = 0; j < charArr.length; j++) {
				if (charArr[j] == null) {
					continue;
				}
				if (charArr[j] == ithChar2) {
					charArr[j] = null;
				}
			}
		}
		for (int j = 0; j < charArr.length; j++) {
			if (charArr[j] != null) {
				return false;
			}
		}
		return true;
	}





	public static boolean isSubStringAnagram(String firstStr, String secondStr) {
		int secondLength = secondStr.length();
		int firstLength = firstStr.length();
		if (secondLength == 0) {
			return true;
		}
		if (firstLength < secondLength || firstLength == 0) {
			return false;
		}

		for (int i = 0; i < firstLength - secondLength + 1; i++) {
			if (isAnagram(firstStr.substring(i, i + secondLength), secondStr)) {
				return true;
			}
		}
		return false;

	}
}
