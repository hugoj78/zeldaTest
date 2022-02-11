package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Data;
import model.Perso;
import utility.Utility;

class DataTest {

	Data dTest;

	@BeforeEach
	void init() {
		dTest = new Data();
	}

	@Test
	void borderMapTest() {
		// GIVEN
		boolean failure = true;

		// WHEN
		Utility.fillMap(dTest);

		// THEN
		for (int i = 0; i < dTest.map.length; i++) {
			for (int j = 0; j < dTest.map[i].length; j++) {
				if (dTest.map[0][j] != '0' || dTest.map[dTest.map.length - 1][j] != '0') {
					failure = false;
				}
			}

			if (dTest.map[i][0] != '0' || dTest.map[i][dTest.map.length - 1] != '0') {
				failure = false;
			}
		}

		assertTrue(failure);

	}

	@Test
	void borderMapInitTest() {
		// GIVEN
		boolean insideInitOk = true;

		// WHEN
		Utility.fillMap(dTest);

		// THEN
		for (int i = 1; i < dTest.map.length - 1; i++) {
			for (int j = 1; j < dTest.map[i].length - 1; j++) {
				if (dTest.map[i][j] != ' ') {
					insideInitOk = false;
				}
			}
		}

		assertTrue(insideInitOk);

	}

	@Test
	void nbOfPersoInArrayListWhenCreatedTest() {
		// GIVEN
		Utility.fillMap(dTest);

		// WHEN
		Utility.createPerso(dTest);

		// THEN
		assertEquals(6, dTest.alPerso.size());

	}

	@Test
	void randomXY999foisTest() {

		for (int i = 0; i < 1000; i++) {
			randomXYTest();
		}

	}

	@Test
	void randomXYTest() {
		// GIVEN
		int min = 1;
		int max = 8;
		// WHEN
		int result = Utility.randomXY(min, max);

		// THEN
		assertTrue(min <= result);
		assertTrue(max >= result);

	}

	@Test
	void checkIfPersoOnMap() {
		// GIVEN
		Utility.fillMap(dTest);
		Utility.createPerso(dTest);

		// WHEN
		Utility.fillMapWithPerso(dTest);

		// THEN
		for (int i = 0; i < dTest.alPerso.size(); i++) {
			Perso perso = dTest.alPerso.get(i);
			assertEquals(perso.getName().charAt(0), dTest.map[perso.getX()][perso.getY()]);
		}
	}

	@Test
	void nbrOfPersoOnMap100foisTest() {

		for (int i = 0; i < 100; i++) {
			dTest = new Data();
			nbrOfPersoOnMapTest();
		}

	}

	@Test
	void nbrOfPersoOnMapTest() {

		Utility.fillMap(dTest);
		Utility.createPerso(dTest);
		Utility.fillMapWithPerso(dTest);

		int countPersoOnMap = 0;

		for (int i = 1; i < dTest.map.length - 1; i++) {
			for (int j = 1; j < dTest.map[i].length - 1; j++) {

				if (dTest.map[i][j] != ' ') {
					countPersoOnMap++;
				}
			}
		}

		assertEquals(dTest.alPerso.size(), countPersoOnMap);
	}

}
