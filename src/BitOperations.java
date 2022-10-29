/**
 * nBit value [0, 63]
 * return -1 in the case of wrong nBit value
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
			long mask;
			if (nBit < 31) {
				mask = 1 << nBit; // all bits are 0 except bit number nBit // 1 << 2 100, 1 << 3 1000
				if ((number & mask) == 0) {
					result = 0;
				} else {
					result = 1;
				}
			}
			if (nBit >= 31) {
				result = (number > 0) ? 0 : 1;
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
			long mask = 1 << nBit; //0010
			if (value) {
				result = number | mask;
				//0011 1010 1011 0111 1111 0101
				//0000 0000 0000 0000 0000 0010
			} else {
				result = number & ~mask;
				//0011 1010 1011 0111 1111 0101
				//1111 1111 1111 1111 1111 1101 <- //0000 0000 0000 0000 0000 0010
			}
		}
		return result;
	}

	/**
	 *
	 * @param number - any number
	 * @param nBit   - bit number
	 * @return new number in which nBit will be inverse (old value - 1, new value - 0)
	 */
	public static long invertBitValue(long number, int nBit) {
		long result = -1;
		if (isValidNbit(nBit)) {
			long mask = 1 << nBit;
			//0101 //0100
			//0001 //0001
			//^
			//0100 //0101
			result = number ^ mask;
		}
		return result;
	}

	private static boolean isValidNbit(int nBit) {
		return nBit < 64 && nBit >= 0;
	}

}
