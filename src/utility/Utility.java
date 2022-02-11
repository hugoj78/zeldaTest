package utility;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import model.Data;
import model.Enemy;
import model.Perso;
import model.Player;

public class Utility {

	public static void fillMap(Data data) {
		for (int i = 0; i < data.map.length; i++) {
			for (int j = 0; j < data.map[i].length; j++) {
				data.map[i][j] = ' ';
				data.map[0][j] = '0';
				data.map[data.map.length - 1][j] = '0';
			}
			data.map[i][0] = '0';
			data.map[i][data.map[i].length - 1] = '0';
		}
	}

	public static void printMap(Data data) {
		for (int i = 0; i < data.map.length; i++) {
			for (int j = 0; j < data.map.length; j++) {
				System.out.print(data.map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void createPersoAndFill(Data data) {

		Player player = new Player("Player", randomXY(1, 8), randomXY(1, 8));
		data.alPerso.add(player);

		data.map[player.getX()][player.getY()] = player.getName().charAt(0);

		for (int i = 0; i < 5; i++) {

			int x = 1, y = 1;

			do {
				x = randomXY(1, 8);
				y = randomXY(1, 8);
			} while (data.map[x][y] != ' ');

			Enemy enemy = new Enemy("Enemy " + i, x, y);

			data.alPerso.add(enemy);

			data.map[enemy.getX()][enemy.getY()] = enemy.getName().charAt(0);

		}
	}

	public static int randomXY(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static String inputString() {
		try {
			Scanner sc = new Scanner(System.in);
			return sc.next();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public static void movePerso(Data d) {
		for (Perso element : d.alPerso) {

		}
	}

}
