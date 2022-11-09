import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	void test() {
		int a;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					a = i * 100 + j * 10 + k;
					assertEquals(k, getThirdNumber(a));
					assertEquals(j, getSecondNumber(a));
					assertEquals(i, getFirstNumber(a));
				}
			}
		}
	}

	@Test
	void countDigitsTest() {
		assertEquals(1, Numbers.countDigits(0));
		assertEquals(1, Numbers.countDigits(1));
		assertEquals(1, Numbers.countDigits(9));
		assertEquals(1, Numbers.countDigits(9));
		assertEquals(2, Numbers.countDigits(10));
		assertEquals(2, Numbers.countDigits(11));
		assertEquals(1, Numbers.countDigits(-1));
		assertEquals(1, Numbers.countDigits(-9));
		assertEquals(2, Numbers.countDigits(-11));
		assertEquals(10, Numbers.countDigits(Integer.MAX_VALUE));
		assertEquals(10, Numbers.countDigits(Integer.MAX_VALUE + 1L));
	}

	@Test
	void getSumOfDigitsTest() {
		assertEquals(0, Numbers.getSumOfDigits(0));
		assertEquals(1, Numbers.getSumOfDigits(1));
		assertEquals(3, Numbers.getSumOfDigits(12));
		assertEquals(6, Numbers.getSumOfDigits(123));
		assertEquals(1, Numbers.getSumOfDigits(1000));
		assertEquals(0, Numbers.getSumOfDigits(-1000)); // method doesn't support negative numbers
	}

	@Test
	void isHappyNumberTest() {
		assertEquals(false, Numbers.isHappyNumber(0));
		assertEquals(false, Numbers.isHappyNumber(1));
		assertEquals(false, Numbers.isHappyNumber(11));
		assertEquals(false, Numbers.isHappyNumber(111));
		assertEquals(false, Numbers.isHappyNumber(1111));
		assertEquals(false, Numbers.isHappyNumber(11111));
		assertEquals(true, Numbers.isHappyNumber(111111));
		assertEquals(false, Numbers.isHappyNumber(1111111));
		assertEquals(false, Numbers.isHappyNumber(-1));
		assertEquals(false, Numbers.isHappyNumber(-1111111));
		assertEquals(false, Numbers.isHappyNumber(-111111)); // method doesn't support negative numbers
	}

	@Test
	void getDigitsTest() {
		int expected[] = { 1, 2, 3, 4 };
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}

	@Test
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;

		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[] { 1, 2, 3, 4 }));
	}

	private int getThirdNumber(int number) {
		return number % 10;
	}

	private int getSecondNumber(int number) {
		return (number / 10) % 10;
	}

	private int getFirstNumber(int number) {
		return (number / 100) % 10;
	}
}
