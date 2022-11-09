import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyArraysTest {

	@Test
	void addsNumberTest() {
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, MyArrays.addsNumber(new int[] { 1, 2, 3 }, 4));
	}
	
	@Test
	void removeNumberTest() {
		assertArrayEquals(new int[] { 2, 3 }, MyArrays.removeNumber(new int[] { 1, 2, 3 }, 0));
		assertArrayEquals(new int[] { 1, 3 }, MyArrays.removeNumber(new int[] { 1, 2, 3 }, 1));
		assertArrayEquals(new int[] { 1, 2 }, MyArrays.removeNumber(new int[] { 1, 2, 3 }, 2));
		assertArrayEquals(new int[] { 1, 2, 3 }, MyArrays.removeNumber(new int[] { 1, 2, 3 }, 3));
	}
	
	@Test
	void insertSortedTest() {
		assertArrayEquals(new int[] { 0, 1, 2 }, MyArrays.insertSorted(new int[] { 1, 2 }, 0));
		assertArrayEquals(new int[] { 1, 2, 3 }, MyArrays.insertSorted(new int[] { 1, 3 }, 2));
		assertArrayEquals(new int[] { 1, 2, 3 }, MyArrays.insertSorted(new int[] { 1, 2 }, 3));
		assertArrayEquals(new int[] { 1, 2, 2, 3 }, MyArrays.insertSorted(new int[] { 1, 2, 3 }, 2));
	}
}
