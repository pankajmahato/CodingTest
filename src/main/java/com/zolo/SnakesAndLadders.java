package com.zolo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SnakesAndLadders {
	final static int WINPOINT = 100;

	static Map<Integer, Integer> snakeMap = new HashMap<>();
	static Map<Integer, Integer> ladderMap = new HashMap<>();





	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] line;


		for (int i = 0; i < n; i++) {
			line = scanner.nextLine().split(" ");
			int st = Integer.parseInt(line[0]);
			int sh = Integer.parseInt(line[1]);
			snakeMap.put(sh, st);
			int lb = Integer.parseInt(line[2]);
			int lt = Integer.parseInt(line[3]);
			ladderMap.put(lb, lt);
		}
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.printf("%10s %15s %30s %30s", "USER", "DICE NO.", "PREVIOUS STATE", "CURRENT STATE");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------");


		int player1 = 0, player2 = 0;
		int currentPlayer = -1;
		while (true) {
			int dice = rollDice();
			if (currentPlayer == -1) {
				int old = player1;
				player1 = calculatePlayerValue(player1, dice);
				printRow("User1", dice, old, player1);
				if (isWin(player1)) {
					System.out
							.println("----------------------------------------------------------------------------------------");
					System.out.println("User1 wins");
					break;
				}
			} else {
				int old = player2;
				player2 = calculatePlayerValue(player2, dice);
				printRow("User2", dice, old, player2);
				if (isWin(player2)) {
					System.out
							.println("----------------------------------------------------------------------------------------");
					System.out.println("User2 wins");
					break;
				}
			}

			currentPlayer = -currentPlayer;
		}
		System.out.println("----------------------------------------------------------------------------------------");
		scanner.close();
	}





	private static int rollDice() {
		return (int) Math.ceil(Math.random() * 6.0);
	}





	private static void printRow(String user, int dice, int pre, int curr) {
		System.out.format("%10s %15s %30s %30s", user, dice, pre, curr);
		System.out.println();
	}





	public static int calculatePlayerValue(int player, int diceValue) {
		player = player + diceValue;

		if (player > WINPOINT) {
			player = player - diceValue;
			return player;
		}

		if (null != snakeMap.get(player)) {
			player = snakeMap.get(player);
		}

		if (null != ladderMap.get(player)) {
			player = ladderMap.get(player);
		}
		return player;
	}





	public static boolean isWin(int player) {
		return WINPOINT == player;
	}
}
