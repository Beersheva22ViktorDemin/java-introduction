import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
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
	
	@Test
	void binarySearchTest() {
		assertEquals(-1, MyArrays.binarySearch(new int[] { 1, 2 }, 0));
		assertEquals(-2, MyArrays.binarySearch(new int[] { 1, 3 }, 2));
		assertEquals(1, MyArrays.binarySearch(new int[] { 1, 2, 3 }, 2));
		assertEquals(1, MyArrays.binarySearch(new int[] { 1, 2, 2, 3 }, 2));
		assertEquals(1, MyArrays.binarySearch(new int[] { 1, 2, 2, 2, 3 }, 2));
		
		int ar[] = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 20, 40 };
		assertEquals(-14, MyArrays.binarySearch(ar, 3));
		assertEquals(3, MyArrays.binarySearch(ar, 2));
		assertEquals(-1, MyArrays.binarySearch(ar, 0));
		assertEquals(13, MyArrays.binarySearch(ar, 4));
		assertEquals(0, MyArrays.binarySearch(ar, 1));
		assertEquals(-16, MyArrays.binarySearch(ar, 25));
		assertEquals(-17, MyArrays.binarySearch(ar, 45));
	}
	
	@Test
	void isOneSwapTestFalse() {
		int ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		int ar2[] = { 1, 2, 3, 4, 5, 10 };
		int ar3[] = { 5, 1, 2, 4, 6, 10 };
		int ar4[] = { 1, 5, 2, 4, 3, 10 };
		int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		int ar6[] = { 1, 3, 20, 4, 5, 6, 10 };
		assertFalse(MyArrays.isOneSwapForSorted(ar1));
		assertFalse(MyArrays.isOneSwapForSorted(ar2));
		assertFalse(MyArrays.isOneSwapForSorted(ar3));
		assertFalse(MyArrays.isOneSwapForSorted(ar4));
		assertFalse(MyArrays.isOneSwapForSorted(ar5));
		assertFalse(MyArrays.isOneSwapForSorted(ar6));
	}
	
	@Test
	void isOneSwapTestTrue() {
		int ar1[] = { 10, 2, 3, 4, 1 };
		int ar2[] = { 1, 2, 4, 3, 5, 10 };
		int ar3[] = { 1, 2, 3, 10, 5, 4 };
		int ar4[] = { 1, 5, 3, 4, 2, 10 };
		int ar5[] = { 1, 2, 3, 4, 10, 5 };
		int ar6[] = { 2, 1, -3, 4, 5, 10 };
		int ar7[] = { 3, 2, 1, 4, 5, 6 };
		int ar8[] = {1, 2, 2, 3, 3, 4, 4, 4, 3, 5};
		int ar9[] = {1, 2, 4, 3, 3, 3, 5};
		assertTrue(MyArrays.isOneSwapForSorted(ar1));
		assertTrue(MyArrays.isOneSwapForSorted(ar2));
		assertTrue(MyArrays.isOneSwapForSorted(ar3));
		assertTrue(MyArrays.isOneSwapForSorted(ar4));
		assertTrue(MyArrays.isOneSwapForSorted(ar5));
		assertTrue(MyArrays.isOneSwapForSorted(ar6));
		assertTrue(MyArrays.isOneSwapForSorted(ar7));
		assertTrue(MyArrays.isOneSwapForSorted(ar8));
		assertTrue(MyArrays.isOneSwapForSorted(ar9));
	}
	
	@Test
	void bubbleSortTest() {
		int[] array = new int[] { 2, 1, 3 };
		MyArrays.bubbleSort(array);
		assertArrayEquals(new int[] { 1, 2, 3 }, array);
		
		array = new int[] { 0, 5, 2, 1, 3 };
		MyArrays.bubbleSort(array);
		assertArrayEquals(new int[] { 0, 1, 2, 3, 5 }, array);
	}
}
