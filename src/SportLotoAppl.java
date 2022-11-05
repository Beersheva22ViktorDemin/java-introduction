public class SportLotoAppl {
	
	public static final long INIT = 0L;

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive numbers can
	 * not be repeated in a sequence of 6 random numbers no additional collections /
	 * arrays
	 */
	public static void main(String[] args) {	
		int newValue = 0;
		long arraySimulator = INIT;
		for (int i = 0; i < 6; i++) {
			do {
//				newValue = getRandomInt(1, 6); //for tests
				newValue = getRandomInt(1, 49);
			} while (isValueExists(arraySimulator, newValue));
			arraySimulator = saveValue(arraySimulator, newValue);
			System.out.print(newValue + " ");
		}
	}

	public static int getRandomInt(int min, int max) {
		return (int)(min + Math.random() * (max - min + 1));
	}
	
	public static long saveValue(long arraySimulator, int value) {
		arraySimulator = BitOperations.setBitValue(arraySimulator, value, true);
		
		return arraySimulator;
	}
	
	public static boolean isValueExists(long arraySimulator, int value) {
		boolean result = false;
		if (BitOperations.getBitValue(arraySimulator, value) > 0) {
			result = true;
		}
		return result;
	}
}
