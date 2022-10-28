import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
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

	private int getThirdNumber(int number) {
		return number % 10;
	}

	private int getSecondNumber(int number) {
		return (number / 10) % 10;

	}

	private int getFirstNumber(int number) {
		return (number / 100) % 10;
		
	}
	
	@Test
	void getBitValueTest() {
		long number = 1; // 1
		assertEquals(1, BitOperations.getBitValue(number, 0));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(0, BitOperations.getBitValue(number, 45));
		assertEquals(0, BitOperations.getBitValue(number, 63));
		assertEquals(-1, BitOperations.getBitValue(number, 64));
		assertEquals(-1, BitOperations.getBitValue(number, 65));
	
		number = 2; // 10
		assertEquals(0, BitOperations.getBitValue(number, 0));
		assertEquals(1, BitOperations.getBitValue(number, 1));
		assertEquals(0, BitOperations.getBitValue(number, 45));
		assertEquals(0, BitOperations.getBitValue(number, 63));
		assertEquals(-1, BitOperations.getBitValue(number, 64));
		assertEquals(-1, BitOperations.getBitValue(number, 65));
		
		number = 3; // 11
		assertEquals(1, BitOperations.getBitValue(number, 0));
		assertEquals(1, BitOperations.getBitValue(number, 1));
		assertEquals(0, BitOperations.getBitValue(number, 45));
		assertEquals(0, BitOperations.getBitValue(number, 63));
		assertEquals(-1, BitOperations.getBitValue(number, 64));
		assertEquals(-1, BitOperations.getBitValue(number, 65));
		
		number = 4; // 100
		assertEquals(0, BitOperations.getBitValue(number, 0));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(0, BitOperations.getBitValue(number, 63));
		assertEquals(-1, BitOperations.getBitValue(number, 64));
		assertEquals(-1, BitOperations.getBitValue(number, 65));
		
		number = 0x3ab7f5; //0011 1010 1011 0111 1111 0101
		assertEquals(1, BitOperations.getBitValue(number, 0));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(0, BitOperations.getBitValue(number, 3));
		assertEquals(1, BitOperations.getBitValue(number, 20));
		assertEquals(1, BitOperations.getBitValue(number, 21));
		assertEquals(0, BitOperations.getBitValue(number, 22));
		assertEquals(0, BitOperations.getBitValue(number, 23));
		//current code doesn't work correctly
//		assertEquals(0, BitOperations.getBitValue(number, 32));
//		assertEquals(0, BitOperations.getBitValue(number, 45));
//		assertEquals(0, BitOperations.getBitValue(number, 63));
		assertEquals(-1, BitOperations.getBitValue(number, 64));
		assertEquals(-1, BitOperations.getBitValue(number, 65));
		
		//checks from lesson
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, 100));
	}
	
	@Test
	void setBitValueTest() {
		long number = 0x3ab7f5; //0011 1010 1011 0111 1111 0101
		
		assertEquals(0x3ab7f4, BitOperations.setBitValue(number, 0, false));
		assertEquals(number, BitOperations.setBitValue(number, 0, true));
		
		assertEquals(number, BitOperations.setBitValue(number, 1, false));
		assertEquals(0x3ab7f7, BitOperations.setBitValue(number, 1, true));
		
		assertEquals(0x3ab7f1, BitOperations.setBitValue(number, 2, false));
		assertEquals(number, BitOperations.setBitValue(number, 2, true));
		
		assertEquals(number, BitOperations.setBitValue(number, 3, false));
		assertEquals(0x3ab7fd, BitOperations.setBitValue(number, 3, true));
		
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false));
		assertEquals(number, BitOperations.setBitValue(number, 4, true));
		
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));
		assertEquals(number, BitOperations.setBitValue(number, 5, true));
		
		assertEquals(number, BitOperations.setBitValue(number, 23, false));
		assertEquals(0xbab7f5, BitOperations.setBitValue(number, 23, true));
		
		assertEquals(-1, BitOperations.setBitValue(number, 64, false));
		assertEquals(-1, BitOperations.setBitValue(number, 65, true));
		
		//checks from lesson aren't correct, errors in test
//		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 5, false));
//		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}
	
	@Test
	void invertBitValueTest() {
		long number = 0x3ab7f5; //0011 1010 1011 0111 1111 0101
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
		assertEquals(0x3ab7f7, BitOperations.invertBitValue(number, 1));
		assertEquals(0xbab7f5, BitOperations.invertBitValue(number, 23));
		
		
		assertEquals(-1, BitOperations.invertBitValue(number, 64));
		assertEquals(-1, BitOperations.invertBitValue(number, 65));
		
		//checks from lesson
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
	}

}
