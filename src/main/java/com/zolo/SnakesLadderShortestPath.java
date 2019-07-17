package com.zolo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakesLadderShortestPath {
	static class qentry {
		int v;
		int dist;
	}





	static int getMinDiceThrows(int move[], int n) {
		int visited[] = new int[n];
		Queue<qentry> q = new LinkedList<>();
		qentry qe = new qentry();
		qe.v = 0;
		qe.dist = 0;

		visited[0] = 1;
		q.add(qe);

		while (!q.isEmpty()) {
			qe = q.remove();
			int v = qe.v;

			if (v == n - 1) {
				break;
			}

			for (int j = v + 1; j <= v + 6 && j < n; ++j) {
				if (visited[j] == 0) {
					qentry a = new qentry();
					a.dist = qe.dist + 1;
					visited[j] = 1;

					if (move[j] != -1) {
						a.v = move[j];
					} else {
						a.v = j;
					}
					q.add(a);
				}
			}
		}
		return qe.dist;
	}





	public static void main(String[] args) {

		int total = 100;

		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int moves[] = new int[total];
		for (int i = 0; i < total; i++) {
			moves[i] = -1;
		}

		String[] line;
		for (int i = 0; i < n; i++) {
			line = scanner.nextLine().split(" ");
			int st = Integer.parseInt(line[0]);
			int sh = Integer.parseInt(line[1]);
			moves[sh - 1] = st - 1;
			int lb = Integer.parseInt(line[2]);
			int lt = Integer.parseInt(line[3]);
			moves[lb - 1] = lt - 1;
		}
		scanner.close();
		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, total));
	}
}