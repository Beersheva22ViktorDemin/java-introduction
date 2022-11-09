public class IsraelIdentity {
	public static final int COUNT_OF_DIGITS = 9;
	
	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false number control sum should be
	 *         multiple of 10 ( sum % 10 == 0) for even indexes (0, 2, 4, 6, 8)
	 *         digits as is for odd indexes (1, 3, 5, 9) digit = digit * 2, if > 9
	 *         the sum of inner digits is taken example, 123456782 => 1 + 4(2 * 2) +
	 *         3 + 8(4 * 2) +5 + 3 (6 * 2 = 12 => 1 + 2) + 7 + 7 (8 * 2=16=>1 + 6) +
	 *         2
	 */
	public static boolean verify(int id) {
		int[] digits = Numbers.getDigits(id);
		if (digits.length != COUNT_OF_DIGITS) {
			return false;
		}
		int sum = getLuhnSum(digits);
		
		return sum % 10 == 0;
	}

	/**
	 * 
	 * @return random number of 9 digits matching right Israel id cycle not more
	 *         than 9 iterations
	 */
	public static int generateRandomId() {
		int min = (int) Math.pow(10, (COUNT_OF_DIGITS - 2));
		int max = (int) Math.pow(10, COUNT_OF_DIGITS - 1) - 1;
		int number = SportLotoAppl.getRandomInt(min, max);
		
		
		return number * 10 + getChecksum(number);
	}
	
	public static int getChecksum(int number) {
		int[] digits = Numbers.getDigits(number);
		int sum = getLuhnSum(digits);
		
		return sum % 10 != 0 ? 10 - sum % 10 : 0;
	}
	
	private static int getLuhnSum(int[] digits) {
		int sum = 0, term, doubleTerm;
		for(int i = 0; i < digits.length; i++) {
			if (i % 2 == 0) {
				term = digits[i];
			} else {
				doubleTerm = digits[i] * 2;
				term = doubleTerm > 9 ? Numbers.getSumOfDigits(doubleTerm) : doubleTerm;
			}
			sum += term;
		}
		
		return sum;
	}
}