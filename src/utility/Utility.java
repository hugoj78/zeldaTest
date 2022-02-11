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
		for (Perso perso : d.alPerso) {
			if (perso.getName().charAt(0) == 'P') {

				String inputString = inputString();

				switchMovePlayer(d, perso, inputString);

			} else if (perso.getName().charAt(0) == 'E') {
				int x = randomXY(1, 4);

				switch (x) {
				case 1:
					if (d.map[perso.getX()][perso.getY() - 1] == ' ') {

						d.map[perso.getX()][perso.getY()] = ' ';
						perso.setY(perso.getY() - 1);
						d.map[perso.getX()][perso.getY()] = perso.getName().charAt(0);

					}
					break;
				case 2:
					if (d.map[perso.getX() + 1][perso.getY()] == ' ') {

						d.map[perso.getX()][perso.getY()] = ' ';
						perso.setX(perso.getX() + 1);
						d.map[perso.getX()][perso.getY()] = perso.getName().charAt(0);

					}
					break;
				case 3:
					if (d.map[perso.getX()][perso.getY() + 1] == ' ') {

						d.map[perso.getX()][perso.getY()] = ' ';
						perso.setY(perso.getY() + 1);
						d.map[perso.getX()][perso.getY()] = perso.getName().charAt(0);

					}
					break;
				case 4:
					if (d.map[perso.getX() - 1][perso.getY()] == ' ') {

						d.map[perso.getX()][perso.getY()] = ' ';
						perso.setX(perso.getX() - 1);
						d.map[perso.getX()][perso.getY()] = perso.getName().charAt(0);

					}
					break;

				default:
					System.out.println("Mauvais random");
				}
			}
		}
	}

	public static void switchMovePlayer(Data d, Perso perso, String inputString) {
		switch (inputString) {
		case "q":
			if (d.map[perso.getX()][perso.getY() - 1] == ' ') {

				d.map[perso.getX()][perso.getY()] = ' ';
				perso.setY(perso.getY() - 1);
				d.map[perso.getX()][perso.getY()] = perso.getName().charAt(0);

			}
			break;
		case "s":
			if (d.map[perso.getX() + 1][perso.getY()] == ' ') {

				d.map[perso.getX()][perso.getY()] = ' ';
				perso.setX(perso.getX() + 1);
				d.map[perso.getX()][perso.getY()] = perso.getName().charAt(0);

			}
			break;
		case "d":
			if (d.map[perso.getX()][perso.getY() + 1] == ' ') {

				d.map[perso.getX()][perso.getY()] = ' ';
				perso.setY(perso.getY() + 1);
				d.map[perso.getX()][perso.getY()] = perso.getName().charAt(0);

			}
			break;
		case "z":
			if (d.map[perso.getX() - 1][perso.getY()] == ' ') {

				d.map[perso.getX()][perso.getY()] = ' ';
				perso.setX(perso.getX() - 1);
				d.map[perso.getX()][perso.getY()] = perso.getName().charAt(0);

			}
			break;

		default:
			System.out.println("Mauvaise Saisie");
		}
	}

}
