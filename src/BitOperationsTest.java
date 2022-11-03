import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BitOperationsTest {	
	@Test
	void getBitValueTest() {		
		long number = 1; // 1
		assertEquals(1, BitOperations.getBitValue(number, 0));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(0, BitOperations.getBitValue(number, 2));
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
		assertEquals(0, BitOperations.getBitValue(number, 29));
		assertEquals(0, BitOperations.getBitValue(number, 30)); //mask = 1073741824
		assertEquals(0, BitOperations.getBitValue(number, 31)); //mask = -2147483648
		assertEquals(0, BitOperations.getBitValue(number, 32)); //mask = 1
		assertEquals(0, BitOperations.getBitValue(number, 45));
		assertEquals(0, BitOperations.getBitValue(number, 63));
		assertEquals(-1, BitOperations.getBitValue(number, 64));
		assertEquals(-1, BitOperations.getBitValue(number, 65));
		
		//checks from lesson
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
		assertEquals(-1, BitOperations.getBitValue(number, 100));
		
		number = Integer.MAX_VALUE; //0111 1111 1111 1111 1111 1111 1111 1111
		assertEquals(1, BitOperations.getBitValue(number, 0));
		assertEquals(1, BitOperations.getBitValue(number, 30));
		assertEquals(0, BitOperations.getBitValue(number, 31));
		
		//-2147483648
		number = Integer.MAX_VALUE + 1; //11111111111111111111111111111111 1000 0000 0000 0000 0000 0000 0000 0000
		assertEquals(0, BitOperations.getBitValue(number, 0));
		assertEquals(0, BitOperations.getBitValue(number, 30));
		assertEquals(1, BitOperations.getBitValue(number, 31));
		
		number = -1; //1111111111111111111111111111111111111111111111111111111111111111
		assertEquals(1, BitOperations.getBitValue(number, 0));
		assertEquals(1, BitOperations.getBitValue(number, 30));
		assertEquals(1, BitOperations.getBitValue(number, 31));
		
		number = -2; //1111111111111111111111111111111111111111111111111111111111111110
		assertEquals(0, BitOperations.getBitValue(number, 0));
		assertEquals(1, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 30));
		assertEquals(1, BitOperations.getBitValue(number, 31));
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
	
		number = 0;
		assertEquals(1, BitOperations.invertBitValue(number, 0));
		assertEquals(2, BitOperations.invertBitValue(number, 1));
		assertEquals(Long.MIN_VALUE, BitOperations.invertBitValue(number, 63)); //1000000000000000000000000000000000000000000000000000000000000000
		assertEquals(Long.MIN_VALUE >> 1 ^ Long.MIN_VALUE, BitOperations.invertBitValue(number, 62)); //0100000000000000000000000000000000000000000000000000000000000000
		assertEquals(Long.MIN_VALUE >> 2 ^ Long.MIN_VALUE >> 1, BitOperations.invertBitValue(number, 61));
//		long result = (Long.MIN_VALUE >> 2 ^ Long.MIN_VALUE >> 1);
//		System.out.println(result);
//		System.out.println(Long.toBinaryString(result));
//		System.out.println(Long.toBinaryString(Long.MIN_VALUE));
//		result = Long.MIN_VALUE;
//		System.out.println(result);
//		System.out.println(Long.toBinaryString(result));
//		result = 0 - (Long.MIN_VALUE >> (63 - 63));
//		System.out.println("mask: " + result);
//		System.out.println(Long.toBinaryString(result));
		
		number = 1;
		assertEquals(0, BitOperations.invertBitValue(number, 0));
		assertEquals(3, BitOperations.invertBitValue(number, 1));
		assertEquals(Long.MIN_VALUE + 1, BitOperations.invertBitValue(number, 63)); //1000000000000000000000000000000000000000000000000000000000000001

		number = 2; //10
		assertEquals(3, BitOperations.invertBitValue(number, 0));
		assertEquals(0, BitOperations.invertBitValue(number, 1));
	}
	
	@Test
	void log2Test() {
		assertEquals(-1, BitOperations.log2(0));
		assertEquals(0, BitOperations.log2(1));
		assertEquals(1, BitOperations.log2(2));
		assertEquals(1, BitOperations.log2(3));
		assertEquals(2, BitOperations.log2(4));
		assertEquals(30, BitOperations.log2(Integer.MAX_VALUE));
		assertEquals(-1, BitOperations.log2(-1));
		assertEquals(-1, BitOperations.log2(Integer.MAX_VALUE + 1)); //Because it is a negative number
	}
	
	
	@Test
	void isMultiplyPower2Test() {
		assertEquals(false, BitOperations.isMultiplyPower2(0));
		assertEquals(true, BitOperations.isMultiplyPower2(1));
		assertEquals(true, BitOperations.isMultiplyPower2(2));
		assertEquals(false, BitOperations.isMultiplyPower2(3));
		assertEquals(true, BitOperations.isMultiplyPower2(4));
		assertEquals(false, BitOperations.isMultiplyPower2(5));
		assertEquals(false, BitOperations.isMultiplyPower2(6));
		assertEquals(false, BitOperations.isMultiplyPower2(7));
		assertEquals(true, BitOperations.isMultiplyPower2(8));
		assertEquals(false, BitOperations.isMultiplyPower2(Integer.MAX_VALUE));
		assertEquals(false, BitOperations.isMultiplyPower2(-1));
		assertEquals(false, BitOperations.isMultiplyPower2(Integer.MAX_VALUE + 1)); //Because it is a negative number
	}
	
	@Test
	void leadingZerosTest() {
		assertEquals(64, BitOperations.leadingZeros(0));
		assertEquals(63, BitOperations.leadingZeros(1));
		assertEquals(62, BitOperations.leadingZeros(2));
		assertEquals(62, BitOperations.leadingZeros(3));
		assertEquals(61, BitOperations.leadingZeros(4));
		assertEquals(61, BitOperations.leadingZeros(5));
		assertEquals(61, BitOperations.leadingZeros(6));
		assertEquals(60, BitOperations.leadingZeros(8));
		assertEquals(64 - 31, BitOperations.leadingZeros(Integer.MAX_VALUE - 1));
		assertEquals(64 - 31, BitOperations.leadingZeros(Integer.MAX_VALUE));
		assertEquals(0, BitOperations.leadingZeros(Long.MIN_VALUE));
		assertEquals(0, BitOperations.leadingZeros(-1));
	}
	
	@Test
	void onesInNumberTest() {
		assertEquals(0, BitOperations.onesInNumber(0));
		assertEquals(1, BitOperations.onesInNumber(1));
		assertEquals(1, BitOperations.onesInNumber(2));
		assertEquals(2, BitOperations.onesInNumber(3));
		assertEquals(1, BitOperations.onesInNumber(4));
		assertEquals(2, BitOperations.onesInNumber(5));
		assertEquals(2, BitOperations.onesInNumber(6));
		assertEquals(3, BitOperations.onesInNumber(7));
		assertEquals(1, BitOperations.onesInNumber(8));
		assertEquals(30, BitOperations.onesInNumber(Integer.MAX_VALUE - 1));
		assertEquals(31, BitOperations.onesInNumber(Integer.MAX_VALUE));
		assertEquals(64 - 31, BitOperations.onesInNumber(Integer.MAX_VALUE + 1));
		assertEquals(64 - 31 + 1, BitOperations.onesInNumber(Integer.MAX_VALUE + 2));
		assertEquals(64, BitOperations.onesInNumber(-1));
	}
}
