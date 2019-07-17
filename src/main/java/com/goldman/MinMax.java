package com.goldman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinMax {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>(Arrays.asList(1, 3));
		List<Integer> row2 = new ArrayList<>(Arrays.asList(5, 2));
		List<Integer> row3 = new ArrayList<>(Arrays.asList(8, 7));

		list.add(row1);
		list.add(row2);
		list.add(row3);

		int n = list.get(0).size();
		int m = list.size();
		int[][] matrix = new int[m][n];

		Set<Integer> lump = new HashSet<>();

		for (int i = 0; i < m; i++) {
			List<Integer> temp = list.get(i);
			for (int j = 0; j < temp.size(); j++) {
				matrix[i][j] = temp.get(j);
				lump.add(temp.get(j));
			}
		}

		System.out.println(lump.size() == m * n);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isColMax(matrix, i, j, m, n) || isColMin(matrix, i, j, m, n) || isRowMax(matrix, i, j, m, n)
						|| isRowMin(matrix, i, j, m, n)) {
					count++;
				}
			}
		}
		System.out.println(count == 0 ? -1 : count);
	}





	private static boolean isRowMin(int[][] matrix, int i, int j, int m, int n) {
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < n; k++) {
			if (min > matrix[i][k]) {
				min = matrix[i][k];
			}
		}
		return min == matrix[i][j];
	}





	private static boolean isRowMax(int[][] matrix, int i, int j, int m, int n) {
		int max = Integer.MIN_VALUE;
		for (int k = 0; k < n; k++) {
			if (max < matrix[i][k]) {
				max = matrix[i][k];
			}
		}
		return max == matrix[i][j];
	}





	private static boolean isColMin(int[][] matrix, int i, int j, int m, int n) {
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < m; k++) {
			if (min > matrix[k][j]) {
				min = matrix[k][j];
			}
		}
		return min == matrix[i][j];
	}





	private static boolean isColMax(int[][] matrix, int i, int j, int m, int n) {
		int max = Integer.MIN_VALUE;
		for (int k = 0; k < m; k++) {
			if (max < matrix[k][j]) {
				max = matrix[k][j];
			}
		}
		return max == matrix[i][j];
	}
}
