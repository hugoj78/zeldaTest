package main;

import model.Data;
import utility.Utility;

public class App {

	static Data d = new Data();

	public static void main(String[] args) {

		System.out.println("\n----  InitMap  ----\n");

		Utility.fillMap(d);
		Utility.printMap(d);

		Utility.createPersoAndFill(d);

		System.out.println("\n---- Placement ----\n");

		Utility.printMap(d);
	}

}
