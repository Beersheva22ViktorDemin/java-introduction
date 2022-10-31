/**
 * nBit value [0, 63] return -1 in the case of wrong nBit value
 */
public class BitOperations {

	/**
	 * @param number - any number
	 * @param nBit   - number of bit
	 * @return value of bit with number nBit
	 */
	public static int getBitValue(long number, int nBit) {
		int result = -1;
		if (isValidNbit(nBit)) {
			long mask = getMask(nBit);
			if ((number & mask) == 0) {
				result = 0;
			} else {
				result = 1;
			}
		}
		return result;
	}

	/**
	 * @param number - any number
	 * @param nBit   - number of bit which will be changed
	 * @param value  - true/false (0 or 1) of bit which will be changed
	 * @return number in which value of nBit bit will have a given value
	 */
	public static long setBitValue(long number, int nBit, boolean value) {
		long result = -1;
		if (isValidNbit(nBit)) {
			long mask = getMask(nBit);
			//TODO clean method, mask is ok now, so we don't need "if" here + add some tests
			if (value) {
				result = number | mask;
				// 0011 1010 1011 0111 1111 0101
				// 0000 0000 0000 0000 0000 0010
			} else {
				result = number & ~mask;
				// 0011 1010 1011 0111 1111 0101
				// 1111 1111 1111 1111 1111 1101 <- //0000 0000 0000 0000 0000 0010
			}
		}
		return result;
	}

	/**
	 *
	 * @param number - any number
	 * @param nBit   - bit number
	 * @return new number in which nBit will be inverse (old value - 1, new value -
	 *         0)
	 */
	public static long invertBitValue(long number, int nBit) {
		long result = -1;
		if (isValidNbit(nBit)) {
			long mask = getMask(nBit);
			// 0101 //0100
			// 0001 //0001
			// ^
			// 0100 //0101
			result = number ^ mask;
		}
		return result;
	}
	
	public static int log2(long number) {
		int result = -1;
		
		if (number < 0) {
			result = 0; //Because log2 of negative number is less than 1
		}

		while (number > 0) {
//			System.out.println(Long.toBinaryString(number));
			if (number > 0) {
				number = number >> 1;
			}
			result++;
		}

		return result;
	}

	private static boolean isValidNbit(int nBit) {
		return nBit < 64 && nBit >= 0;
	}
	
	/**
	 * @param nBit
	 * @return mask example 0000 0010 for nBit = 2
	 */
	private static long getMask(int nBit) {
		return 1L << nBit;
	}

}
