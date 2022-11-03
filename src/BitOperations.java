/**
 * nBit value [0, 63] return -1 in the case of wrong nBit value
 */
public class BitOperations {
	
	private static final int N_BITS = 64;

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
			// TODO clean method, mask is ok now, so we don't need "if" here + add some
			// tests
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

		while (number > 0) {
//			System.out.println(Long.toBinaryString(number));
			if (number > 0) {
				number = number >> 1;
			}
			result++;
		}

		return result;
	}

	public static boolean isMultiplyPower2(long number) {
		if (number <= 0) {
			return false;
		}

		// 1111 - is not multiply power 2
		// 1110
		// 1110

		// 0100 - is multiply power 2
		// 0011
		// 0000

		if ((number & (number - 1)) == 0) {
			return true;
		}

		return false;
	}

	public static int leadingZeros(long number) {
		int res = 0;
		int nBit = N_BITS - 1;
		while (nBit >= 0 && getBitValue(number, nBit) == 0) {
			nBit--;
			res++;
		}
		return res;
	}

	public static int onesInNumber(long number) {
		int res = 0;
		for (int i = 0; i < N_BITS; i++) {
			if (getBitValue(number, i) == 1) {
				res++;
			}
		}
		return res;
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
