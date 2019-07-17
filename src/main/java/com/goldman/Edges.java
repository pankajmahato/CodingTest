package com.goldman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Edges {
	public static void main(String[] args) throws java.lang.Exception {

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>(Arrays.asList(1, 0, 0, 1));
		List<Integer> row2 = new ArrayList<>(Arrays.asList(0, 1, 1, 1));
		List<Integer> row3 = new ArrayList<>(Arrays.asList(1, 0, 0, 1));

		list.add(row1);
		list.add(row2);
		list.add(row3);
		int n = list.get(0).size();
		int m = list.size();
		int[][] M = new int[m][n];

		for (int i = 0; i < m; i++) {
			List<Integer> temp = list.get(i);
			for (int j = 0; j < temp.size(); j++) {
				M[i][j] = temp.get(j);
			}
		}

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (M[i][j] == 0) {
					continue;
				}
				if (isIndexValid(i, j + 1, n, m) && M[i][j + 1] == 1) {
					count++;
				}
				if (isIndexValid(i + 1, j, n, m) && M[i + 1][j] == 1) {
					count++;
				}
				if (isIndexValid(i + 1, j + 1, n, m) && M[i + 1][j + 1] == 1) {
					count++;
				}
				if (isIndexValid(i, j - 1, n, m) && M[i][j - 1] == 1) {
					count++;
				}
				if (isIndexValid(i - 1, j, n, m) && M[i - 1][j] == 1) {
					count++;
				}
				if (isIndexValid(i - 1, j - 1, n, m) && M[i - 1][j - 1] == 1) {
					count++;
				}
				if (isIndexValid(i - 1, j + 1, n, m) && M[i - 1][j + 1] == 1) {
					count++;
				}
				if (isIndexValid(i + 1, j - 1, n, m) && M[i + 1][j - 1] == 1) {
					count++;
				}
				M[i][j] = 0;
			}
		}
		System.out.println(count);
	}





	static boolean isIndexValid(int i, int j, int n, int m) {
		if (i < m && j < n && i >= 0 && j >= 0) {
			return true;
		} else {
			return false;
		}

	}

}
