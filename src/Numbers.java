public class Numbers {
	public static int countDigits(long number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while (number != 0);
		return res;
	}

	/**
	 * 
	 * @param number
	 * @return true only if number comprises of 6 digits and sum of first three
	 *         digits equals the sum of last three digits
	 */
	public static boolean isHappyNumber(int number) {
		int firstPart = number / 1000;
		int secondPart = number % 1000;
		int sumFirst = getSumOfDigits(firstPart);
		int sumSecond = getSumOfDigits(secondPart);

		return number > 0 && sumFirst == sumSecond;
	}
	
	public static int getSumOfDigits(int number)
	{
		int result = 0;
		//methods works only with number >= 0
		while (number > 0) {
			result += number % 10;
			number = number / 10;
		}
		return result;
	}
}